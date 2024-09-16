package com.vibely.idgenerator.controller;

import com.vibely.idgenerator.service.SnowflakeGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/generator")
@AllArgsConstructor
public class SnowflakeGeneratorController {

    private final SnowflakeGeneratorService snowflakeGeneratorService;

    @GetMapping
    public Mono<Long> generateId() {
        return snowflakeGeneratorService.nextId();
    }

}
