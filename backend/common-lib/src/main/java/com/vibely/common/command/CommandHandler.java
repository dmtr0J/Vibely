package com.vibely.common.command;

import reactor.core.CorePublisher;

public interface CommandHandler<C extends Command, R extends CorePublisher<?>> {
    R handle(C command);
}
