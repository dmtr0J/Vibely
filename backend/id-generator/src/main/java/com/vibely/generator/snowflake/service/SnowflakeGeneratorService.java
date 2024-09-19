package com.vibely.generator.snowflake.service;

import com.vibely.generator.snowflake.Snowflake;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SnowflakeGeneratorService {

    private final Snowflake generator = new Snowflake(1L);

    public Mono<Long> nextId() {
        return Mono.just(generator.nextId());
    }

    public Flux<Long> nextIds(short count) {
        return Flux.fromIterable(generator.nextIds(count));
    }
}
