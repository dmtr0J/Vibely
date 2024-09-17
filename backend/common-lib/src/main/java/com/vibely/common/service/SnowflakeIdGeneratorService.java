package com.vibely.common.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SnowflakeIdGeneratorService {

    private final WebClient snowflakeClient;

    public SnowflakeIdGeneratorService(
            @Qualifier("snowflakeClient") WebClient snowflakeClient
    ) {
        this.snowflakeClient = snowflakeClient;
    }

    public Mono<Long> generateId() {
        return snowflakeClient.get()
                .uri("/api/v1/generator/snowflake")
                .retrieve()
                .bodyToMono(Long.class);
    }
}
