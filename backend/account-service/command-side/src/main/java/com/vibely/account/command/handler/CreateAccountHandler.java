package com.vibely.account.command.handler;

import com.vibely.account.command.command.CreateAccountCommand;
import com.vibely.account.command.mapper.EventMapper;
import com.vibely.account.command.repository.AccountEventRepository;
import com.vibely.common.command.Command;
import com.vibely.common.command.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreateAccountHandler implements CommandHandler<CreateAccountCommand> {

    private final AccountEventRepository accountEventRepository;
    private final EventMapper eventMapper;
    // Event Producer

    public void handle(CreateAccountCommand command) {


        // create account aggregate
        // add aggregate to EventStore

        // publish event


    }
}


