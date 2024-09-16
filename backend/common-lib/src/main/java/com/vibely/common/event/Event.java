package com.vibely.common.event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Event {
    /*
    * Unique event ID
    * The type of the event
    * Identifies the aggregate
    * The serialized event, such as JSON
    * */

    private UUID id = UUID.randomUUID();
    private Long version;
    private Long aggregateId;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String data; // json
}
