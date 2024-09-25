package com.vibely.user.repository;

import com.vibely.common.event.Event;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventRepository extends ReactiveCrudRepository<Event, Long> {
}
