package com.vibely.common.event.user;

import com.vibely.common.event.Event;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table("events")
public class CreateAccountEvent extends Event {

    @Column("event_type")
    private final String EVENT_TYPE = "create-account";
}
