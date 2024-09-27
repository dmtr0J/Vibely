package com.vibely.user.controller;

import com.vibely.common.bus.CommandBus;
import com.vibely.user.command.CreateAccountCommand;
import com.vibely.user.service.AccountCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user/command/account")
public class AccountCommandController {

    private final CommandBus commandBus;

    @PostMapping
    public Mono<ResponseEntity<Void>> createAccount(@RequestBody @Valid CreateAccountCommand command) {
        return commandBus.dispatchCommand(command);
    }


}
