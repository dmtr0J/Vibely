package com.vibely.common.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SnowflakeIdGeneratorClient {

    private final String url = "http://localhost:9100";

    @Bean("snowflakeClient")
    public WebClient getClient() {
        return WebClient.create(this.url);
    }

}
