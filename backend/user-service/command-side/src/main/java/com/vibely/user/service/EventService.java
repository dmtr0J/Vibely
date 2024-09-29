package com.vibely.user.service;

import com.vibely.common.event.Event;
import com.vibely.user.repository.UserEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EventService {

    private final UserEventRepository userEventRepository;

    public Flux<Event> findAll() {
        return userEventRepository.findAll();
    }

    @Transactional
    public Mono<Event> save(Event event) {
        return userEventRepository.save(event);
    }

    @Transactional
    public Mono<Event> update(Event event) {
        return userEventRepository.save(event);
    }
}
