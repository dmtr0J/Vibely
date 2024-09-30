package com.vibely.user.controller;

import com.vibely.common.bus.CommandDispatcher;
import com.vibely.common.service.SnowflakeIdGeneratorService;
import com.vibely.user.command.CreateAccountCommand;
import com.vibely.user.handler.CreateAccountHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user/command/account")
public class AccountCommandController {

    private final CreateAccountHandler createAccountHandler;

    @PostMapping
    public Mono<ResponseEntity<Long>> createAccount(@RequestBody @Valid CreateAccountCommand command) {
        return createAccountHandler.handle(command)
                .map(id -> ResponseEntity.status(HttpStatus.CREATED).body(id));
    }

    @DeleteMapping
    public Mono<ResponseEntity<Void>> deleteAccount(@RequestParam Long id) {
        return null;
    }

}
