package com.vibely.common.bus;

import com.vibely.common.command.Command;
import com.vibely.common.command.CommandHandler;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Deprecated
@Component
public class CommandDispatcher {

    private final Map<Class<?>, CommandHandler<?, ?>> commandHandlers = new HashMap<>();
    private final Map<String, Object> beansWithHandlers;

    public CommandDispatcher(Map<String, Object> beansWithHandlers) {
        this.beansWithHandlers = beansWithHandlers;
    }

    @PostConstruct
    public void registerHandlers() {
        for (Object bean : beansWithHandlers.values()) {
            for (Method method : bean.getClass().getMethods()) {
                if (method.isAnnotationPresent(HandleCommand.class)) {
                    Class<?> commandType = method.getAnnotation(HandleCommand.class).commandType();
                    CommandHandler<?, ?> handler = (CommandHandler<?, ?>) bean;
                    commandHandlers.put(commandType, handler);
                }
            }
        }
    }

    public <C extends Command, R> R dispatchCommand(C command) {
        CommandHandler<C, R> handler = getCommandHandler(command.getClass());
        return handler.handle(command);
    }

    @SuppressWarnings("unchecked")
    private <C extends Command, R> CommandHandler<C, R> getCommandHandler(Class<?> commandClass) {
        CommandHandler<?, ?> handler = commandHandlers.get(commandClass);
        if (handler == null) {
            throw new IllegalArgumentException("Handler not found for command class: " + commandClass);
        }
        return (CommandHandler<C, R>) handler;
    }
}
