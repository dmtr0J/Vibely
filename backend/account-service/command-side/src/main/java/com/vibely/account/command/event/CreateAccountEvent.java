package com.vibely.account.command.event;

import com.vibely.common.event.Event;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateAccountEvent extends Event {

    private static final String EVENT_TYPE = "create-account";


}
