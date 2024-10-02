package com.vibely.user.handler;

import com.vibely.common.model.Account;
import com.vibely.common.service.JsonSerializationService;
import com.vibely.user.command.CreateAccountCommand;
import com.vibely.common.event.user.CreateAccountEvent;
import com.vibely.common.command.CommandHandler;
import com.vibely.common.service.SnowflakeIdGeneratorService;
import com.vibely.user.factory.UserAccountFactory;
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
public class CreateAccountHandler implements CommandHandler<CreateAccountCommand, Mono<Long>> {

    private final EventService eventService;
    private final SnowflakeIdGeneratorService snowflakeIdGeneratorService;
    private final UserAccountFactory userAccountFactory;
    private final JsonSerializationService jsonSerializationService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    //TODO Refactor
    @Transactional
    public Mono<Long> handle(CreateAccountCommand command) {
        return snowflakeIdGeneratorService.generateListIds((short) 2)
                .flatMap(ids -> {
                    Long accountId = ids.get(0);
                    Long eventId = ids.get(1);

                    Account account = userAccountFactory
                            .createAccountFromCommand(command, accountId);

                    String accountJson = jsonSerializationService
                            .serialize(account);

                    CreateAccountEvent event = CreateAccountEvent.builder()
                            .id(eventId)
                            .version(1L)
                            .createdAt(LocalDateTime.now())
                            .data(accountJson)
                            .build();

                    eventService.save(event)
                            .flatMap(savedEvent -> Mono.fromFuture(
                                    kafkaTemplate.send("user.account.created", savedEvent.getData())));

                    return Mono.just(accountId);
                });
    }
}


