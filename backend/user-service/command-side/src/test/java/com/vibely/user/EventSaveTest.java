package com.vibely.user;

import com.vibely.common.event.user.CreateAccountEvent;
import com.vibely.user.repository.UserEventRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EventSaveTest {

    private UserEventRepository eventRepository;

    @BeforeEach
    void setUp() {
        eventRepository = mock(UserEventRepository.class);
    }


    @Test
    void testEventSave() {
        CreateAccountEvent event = CreateAccountEvent.builder()
                .id(1L)
                .version(1L)
                .createdAt(LocalDateTime.now())
                .data("accountJson")
                .build();

        when(userRepository.save(user)).thenReturn(Mono.empty());

        Mono<Void> result = userService.saveUser(user);

        StepVerifier.create(result)
                .verifyComplete();


    }
}
