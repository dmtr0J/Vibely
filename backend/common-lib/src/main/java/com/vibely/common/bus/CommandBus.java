package com.vibely.common.bus;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class CommandBus {

    private final Map<Class<?>, Method> commandHandlers = new HashMap<>();
    private final Map<String, Object> beansWithHandlers;

    public CommandBus(Map<String, Object> beansWithHandlers) {
        this.beansWithHandlers = beansWithHandlers;
    }

    @PostConstruct
    public void registerHandlers() {
        for (Object bean : beansWithHandlers.values()) {
            for (Method method : bean.getClass().getMethods()) {
                if (method.isAnnotationPresent(CommandHandler.class)) {
                    Class<?> commandType = method.getAnnotation(CommandHandler.class).commandType();
                    commandHandlers.put(commandType, method);
                }
            }
        }
    }

    public <T> void dispatchCommand(T command) {
        Method handlerMethod = commandHandlers.get(command.getClass());
        if (handlerMethod == null) {
            throw new IllegalArgumentException("No command handler found for " + command.getClass().getName());
        }
        try {
            Object bean = beansWithHandlers.get(handlerMethod.getDeclaringClass().getName());
            handlerMethod.invoke(bean, command);
        } catch (Exception e) {
            throw new RuntimeException("Failed to dispatch command: " + command.getClass().getName(), e);
        }
    }
}
