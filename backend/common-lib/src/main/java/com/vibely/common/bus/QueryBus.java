//package com.vibely.common.bus;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//
//@Deprecated
//@Component
//public class QueryBus {
//
//    private final Map<Class<?>, Method> queryHandlers = new HashMap<>();
//    private final Map<String, Object> beansWithHandlers;
//
//    public QueryBus(Map<String, Object> beansWithHandlers) {
//        this.beansWithHandlers = beansWithHandlers;
//    }
//
//    @PostConstruct
//    public void registerHandlers() {
//        for (Object bean : beansWithHandlers.values()) {
//            for (Method method : bean.getClass().getMethods()) {
//                if (method.isAnnotationPresent(HandleQuery.class)) {
//                    Class<?> queryType = method.getAnnotation(HandleQuery.class).queryType();
//                    queryHandlers.put(queryType, method);
//                }
//            }
//        }
//    }
//
//
//    public <T, R> R dispatchQuery(T query) {
//        Method handlerMethod = queryHandlers.get(query.getClass());
//        if (handlerMethod == null) {
//            throw new IllegalArgumentException("No query handler found for " + query.getClass().getName());
//        }
//        try {
//            Object bean = beansWithHandlers.get(handlerMethod.getDeclaringClass().getName());
//            return (R) handlerMethod.invoke(bean, query);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to dispatch query: " + query.getClass().getName(), e);
//        }
//    }
//}
