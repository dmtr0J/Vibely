package com.vibely.user.event;

import com.vibely.common.event.Event;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateAccountEvent extends Event {

    private static final String EVENT_TYPE = "create-account";

}
