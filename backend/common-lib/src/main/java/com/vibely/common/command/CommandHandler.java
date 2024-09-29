package com.vibely.common.command;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
