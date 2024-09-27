package com.vibely.user.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vibely.common.bus.HandleCommand;
import com.vibely.common.entity.Account;
import com.vibely.common.entity.Role;
import com.vibely.common.entity.Status;
import com.vibely.user.command.CreateAccountCommand;
import com.vibely.common.event.user.CreateAccountEvent;
import com.vibely.common.command.CommandHandler;
import com.vibely.common.service.SnowflakeIdGeneratorService;
import com.vibely.user.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateAccountHandler implements CommandHandler<CreateAccountCommand> {

    private final EventService eventService;
    private final SnowflakeIdGeneratorService snowflakeIdGeneratorService;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    //TODO Refactor
    @Transactional
    @HandleCommand(commandType = CreateAccountCommand.class)
    public Mono<Void> handle(CreateAccountCommand command) {
        return snowflakeIdGeneratorService.generateIds((short) 2)
                .collectList()
                .flatMap(ids -> {
                    if (ids.size() < 2) {
                        return Mono.error(new RuntimeException("Not enough IDs generated"));
                    }

                    Long accountId = ids.get(0);
                    Long eventId = ids.get(1);

                    Account account = Account.builder()
                            .id(accountId)
                            .username(command.getUsername())
                            .name(command.getName())
                            .email(command.getEmail())
                            .password(command.getPassword())
                            .dateOfBirth(command.getDateOfBirth())
                            .role(Role.USER)
                            .status(Status.CREATED)
                            .createdAt(LocalDateTime.now())
                            .build();

                    String accountJson;
                    try {
                        accountJson = objectMapper.writeValueAsString(account);
                    } catch (JsonProcessingException e) {
                        log.error("Error serializing account", e);
                        return Mono.error(new RuntimeException("Failed to serialize account to JSON", e));
                    }

                    CreateAccountEvent event = CreateAccountEvent.builder()
                            .id(eventId)
                            .version(1L)
                            .createdAt(LocalDateTime.now())
                            .data(accountJson)
                            .build();

                    return eventService.save(event)
                            .flatMap(savedEvent -> Mono.fromFuture(
                                    kafkaTemplate.send("user.account.created", savedEvent.getData())));
                })
                .then();
    }
}


