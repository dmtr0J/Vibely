package com.vibely.user.controller;

import com.vibely.common.bus.CommandDispatcher;
import com.vibely.common.service.SnowflakeIdGeneratorService;
import com.vibely.user.command.CreateAccountCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user/command/account")
public class AccountCommandController {

    private final SnowflakeIdGeneratorService snowflakeIdGeneratorService;

    @PostMapping
    public Mono<ResponseEntity<Void>> createAccount(@RequestBody @Valid CreateAccountCommand command) {
        return null;
    }

}
