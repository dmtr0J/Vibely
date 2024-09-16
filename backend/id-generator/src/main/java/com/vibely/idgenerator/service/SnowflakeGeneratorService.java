package com.vibely.idgenerator.service;

import com.vibely.idgenerator.generator.Snowflake;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SnowflakeGeneratorService {

    private final Snowflake generator = new Snowflake(1L);

    public Mono<Long> nextId() {
        return Mono.just(generator.nextId());
    }
}
