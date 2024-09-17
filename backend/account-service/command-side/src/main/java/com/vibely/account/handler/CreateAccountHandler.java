package com.vibely.account.handler;

import com.vibely.account.command.CreateAccountCommand;
import com.vibely.account.mapper.EventMapper;
import com.vibely.account.repository.AccountEventRepository;
import com.vibely.common.command.CommandHandler;
import com.vibely.common.service.SnowflakeIdGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreateAccountHandler implements CommandHandler<CreateAccountCommand> {

    private final AccountEventRepository accountEventRepository;
    private final EventMapper eventMapper;
    private final SnowflakeIdGeneratorService snowflakeIdGeneratorService;
    // Event Producer

    public void handle(CreateAccountCommand command) {


        // create account aggregate
        // add aggregate to EventStore

        // publish event


    }
}


