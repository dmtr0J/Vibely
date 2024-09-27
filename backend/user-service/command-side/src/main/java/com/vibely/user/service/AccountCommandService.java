package com.vibely.user.service;

import com.vibely.common.entity.Account;
import com.vibely.user.command.CreateAccountCommand;
import com.vibely.user.handler.CreateAccountHandler;
import com.vibely.user.repository.UserEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountCommandService {

    private final CreateAccountHandler createAccountHandler;

    public Mono<ResponseEntity<Void>> createAccount(CreateAccountCommand command) {

        // Validation email, name - unique

        return createAccountHandler.handle(command)
                .then(Mono.just(ResponseEntity.status(HttpStatus.CREATED).build()));
    }
}