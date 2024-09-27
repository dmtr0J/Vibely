package com.vibely.common.bus;

import com.vibely.common.command.Command;
import jakarta.annotation.PostConstruct;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.CorePublisher;
import reactor.core.publisher.Mono;

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
                if (method.isAnnotationPresent(HandleCommand.class)) {
                    Class<?> commandType = method.getAnnotation(HandleCommand.class).commandType();
                    commandHandlers.put(commandType, method);
                }
            }
        }
    }

    public <T extends Command, R> R dispatchCommand(T command) {
        Method handlerMethod = commandHandlers.get(command.getClass());
        if (handlerMethod == null) {
            throw new IllegalArgumentException("No command handler found for " + command.getClass().getName());
        }
        try {
            Object bean = beansWithHandlers.get(handlerMethod.getDeclaringClass().getName());
            return (R) handlerMethod.invoke(bean, command);
        } catch (Exception e) {
            throw new RuntimeException("Failed to dispatch command: " + command.getClass().getName(), e);
        }
    }
}
