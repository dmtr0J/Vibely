package com.vibely.account.service;

import com.vibely.account.command.CreateAccountCommand;
import com.vibely.account.handler.CreateAccountHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CommandService {

    private final CreateAccountHandler createAccountHandler;

    public Mono<ResponseEntity<Void>> createAccount(CreateAccountCommand command) {

        // Validation email, name - unique

        createAccountHandler.handle(command);

        // --ok is 200--  NEED 201 = CREATED
        return Mono.just(ResponseEntity.ok().build());
    }
}
