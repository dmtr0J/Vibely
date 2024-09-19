package com.vibely.account.event;

import com.vibely.common.event.Event;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CreateAccountEvent extends Event {

    private static final String EVENT_TYPE = "create-account";

}
