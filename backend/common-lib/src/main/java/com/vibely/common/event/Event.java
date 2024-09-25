package com.vibely.common.event;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table("events")
public abstract class Event {

    @Id
    @NotEmpty
    @Column("event_id")
    private Long id;

    @NotEmpty
    @Column("version")
    private Long version;

    @NotEmpty
    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("data")
    private String data;

}
