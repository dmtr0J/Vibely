package com.vibely.user.repository;

import com.vibely.common.event.Event;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountEventRepository extends ReactiveCrudRepository<Event, UUID> {
}
