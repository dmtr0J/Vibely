package com.vibely.common.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@SuperBuilder
public class Event {
    private Long id;
    private Long version;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private String data; // json
}
