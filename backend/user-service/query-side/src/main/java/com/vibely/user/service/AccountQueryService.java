package com.vibely.user.service;

import com.vibely.common.entity.Account;
import com.vibely.user.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountQueryService {

    private final AccountRepository accountRepository;

    public Flux<ResponseEntity<Account>> getAllAccounts() {
        return accountRepository.findAll()
                .map(ResponseEntity::ok);
    }
}
