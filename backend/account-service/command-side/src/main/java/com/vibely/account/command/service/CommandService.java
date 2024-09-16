package com.vibely.account.command.service;

import com.vibely.account.command.command.CreateAccountCommand;
import com.vibely.account.command.handler.CreateAccountHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CommandService {

    private final CreateAccountHandler createAccountHandler;

    public Mono<ResponseEntity<Void>> createAccount(CreateAccountCommand command) {
        createAccountHandler.handle(command);
        // Throw errors

        // --ok is 200--  NEED 201 = CREATED
        return Mono.just(ResponseEntity.ok().build());
    }
}
