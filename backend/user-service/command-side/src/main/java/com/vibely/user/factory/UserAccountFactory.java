package com.vibely.user.factory;

import com.vibely.common.model.Account;
import com.vibely.common.model.Role;
import com.vibely.common.model.Status;
import com.vibely.user.command.CreateAccountCommand;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserAccountFactory implements AccountFactory {

    public Account createAccount() {
        // TODO
        return null;
    }

    public Account createAccountFromCommand(CreateAccountCommand command, long accountId) {
        return Account.builder()
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
    }

}
