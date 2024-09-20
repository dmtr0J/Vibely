package com.vibely.account.controller;

import com.vibely.account.command.CreateAccountCommand;
import com.vibely.account.service.CommandService;
import com.vibely.common.service.SnowflakeIdGeneratorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/account")
public class AccountCommandController {

    private final CommandService commandService;
    private final KafkaTemplate<String, String> kafkaTemplate;

//    @GetMapping
//    public void kafka() {
//        kafkaTemplate.send("testTopic", "hello from kafka");
//    }

    @PostMapping
    public Mono<ResponseEntity<Void>> createAccount(@Valid CreateAccountCommand command) {
        return commandService.createAccount(command);
    }

//    @KafkaListener(topics = "testTopic", groupId = "groupId2")
//    public void listenGroupFoo(String message) {
//        System.out.println("Received Message in group groupId1: " + message);
//    }

}
