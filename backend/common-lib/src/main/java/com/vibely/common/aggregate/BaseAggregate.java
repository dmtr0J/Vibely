package com.vibely.common.aggregate;

import java.time.LocalDateTime;

public class BaseAggregate implements Aggregate {

    private long id;
    private int revision;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();


}
