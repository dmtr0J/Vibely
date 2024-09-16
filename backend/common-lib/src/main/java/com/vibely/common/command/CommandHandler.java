package com.vibely.common.command;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}
