package com.vibely.account.command.events;

import com.vibely.common.aggregate.Aggregate;
import com.vibely.common.event.AbstractBaseEvent;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateAccountEvent extends AbstractBaseEvent {

    private static final String EVENT_TYPE = "create-account";


}
