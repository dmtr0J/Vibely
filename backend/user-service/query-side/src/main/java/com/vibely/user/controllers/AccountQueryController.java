package com.vibely.user.controllers;

import com.vibely.common.entity.Account;
import com.vibely.user.service.AccountQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user/query/account")
public class AccountQueryController {

    private final AccountQueryService accountQueryService;

    @GetMapping("/all")
    public Flux<ResponseEntity<Account>> getAllAccounts() {
        return this.accountQueryService.getAllAccounts();
    }
}
