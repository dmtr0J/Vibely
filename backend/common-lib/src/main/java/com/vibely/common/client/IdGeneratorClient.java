package com.vibely.common.client;

import org.springframework.web.reactive.function.client.WebClient;

public class IdGeneratorClient {

    private static WebClient client = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .build();



}
