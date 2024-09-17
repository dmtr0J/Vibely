package com.vibely.account.aggregate;

import java.time.LocalDateTime;

public class BaseAggregate {

    private Long id;
    private Long version;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
