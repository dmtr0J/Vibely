package com.vibely.user.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vibely.common.entity.Account;
import com.vibely.common.event.EventHandler;
import com.vibely.common.event.user.CreateAccountEvent;
import com.vibely.user.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateAccountEventHandler implements EventHandler {

    private final AccountRepository accountRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    @KafkaListener(topics = "user.account.created")
    public void handle(String dataJson) {
        try {
            accountRepository.save(objectMapper.readValue(dataJson, Account.class))
                    .subscribe();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
