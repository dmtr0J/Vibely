package com.vibely.account.command.handlers;

import com.vibely.account.command.commands.CreateAccountCommand;
import com.vibely.account.command.mappers.EventMapper;
import com.vibely.account.command.repositories.AccountEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommandHandler {

    private final AccountEventRepository accountEventRepository;
    private final EventMapper eventMapper;

    public void handle(CreateAccountCommand command) {
        // TODO


        //accountEventRepository.save(eventMapper.toEvent(command));

        // map (MapStruct)
        // CreateAccountCommand -> Account
        // handle - timestamps, role, status etc.

        // save in event-repo

        // crete event (logic of event bus - kafka )
    }

}
