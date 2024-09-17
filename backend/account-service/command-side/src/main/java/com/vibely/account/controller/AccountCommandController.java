package com.vibely.account.controller;

import com.vibely.account.command.CreateAccountCommand;
import com.vibely.account.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/account")
public class AccountCommandController {

    private final CommandService commandService;

    @PostMapping
    public Mono<ResponseEntity<Void>> createAccount(CreateAccountCommand command) {
        // TODO
        // Command service

        return commandService.createAccount(command);
    }

}
