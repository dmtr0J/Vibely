package com.vibely.user.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vibely.common.entity.Account;
import com.vibely.common.entity.Role;
import com.vibely.common.entity.Status;
import com.vibely.user.command.CreateAccountCommand;
import com.vibely.user.event.CreateAccountEvent;
import com.vibely.user.repository.AccountEventRepository;
import com.vibely.common.command.CommandHandler;
import com.vibely.common.service.SnowflakeIdGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateAccountHandler implements CommandHandler<CreateAccountCommand> {

    private final AccountEventRepository accountEventRepository;
    private final SnowflakeIdGeneratorService snowflakeIdGeneratorService;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    //TODO Refactor
    @Transactional
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
                            .data(accountJson)
                            .build();

                    return accountEventRepository.save(event)
                            .flatMap(savedEvent -> Mono.fromFuture(
                                    kafkaTemplate.send("user.account.created", savedEvent.getData())));
                })
                .then();
    }
}


