package com.vibely.common.event;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event {
    private Long id;
    private Long version;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private String data; // json
}
