package com.vibely.common.event;

import com.vibely.common.aggregate.Aggregate;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class AbstractBaseEvent implements Event {

    private UUID id;
    private long aggregateId;
    private long issuerId;
    private int version;
    private String data;

    public abstract void copyTo(Aggregate aggregate);
}
