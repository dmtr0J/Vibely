package com.vibely.account.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vibely.account.command.CreateAccountCommand;
import com.vibely.account.event.CreateAccountEvent;
import com.vibely.account.mapper.EventMapper;
import com.vibely.account.repository.AccountEventRepository;
import com.vibely.common.command.CommandHandler;
import com.vibely.common.entity.Account;
import com.vibely.common.entity.Role;
import com.vibely.common.entity.Status;
import com.vibely.common.service.SnowflakeIdGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateAccountHandler implements CommandHandler<CreateAccountCommand> {

    private final AccountEventRepository accountEventRepository;
    private final SnowflakeIdGeneratorService snowflakeIdGeneratorService;
    private final ObjectMapper objectMapper;
    // Event Producer

    @Transactional
    public void handle(CreateAccountCommand command) {
//        snowflakeIdGeneratorService.generateIds((short) 2)
//                .collectList()
//                .flatMap(ids -> {
//                    try {
//                        Account account = Account.builder()
//                                .id(ids.getFirst())
//                                .username(command.getUsername())
//                                .name(command.getName())
//                                .email(command.getEmail())
//                                .password(command.getPassword())
//                                .dateOfBirth(command.getDateOfBirth())
//                                .role(Role.USER)
//                                .status(Status.CREATED)
//                                .build();
//
//                        CreateAccountEvent event = CreateAccountEvent.builder()
//                                .id(ids.get(1))
//                                .version(1L)
//                                .data(objectMapper.writeValueAsString(account))
//                                .build();
//
//                        return accountEventRepository.save(event);
//
//                    } catch (JsonProcessingException e) {
//                        log.error(e.getMessage(), e);
//                    }
//                })
//                .flatMap(event -> )


    }
}


