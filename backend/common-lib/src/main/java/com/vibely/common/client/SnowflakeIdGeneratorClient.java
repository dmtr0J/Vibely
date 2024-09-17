package com.vibely.common.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SnowflakeIdGeneratorClient {

    private final String url = "http://localhost:8080";

    @Bean("snowflakeClient")
    public WebClient getClient() {
        return WebClient.create(this.url);
    }

}
