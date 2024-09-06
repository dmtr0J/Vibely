package com.vibely.account.command.repositories;

import com.vibely.common.event.AbstractEvent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEventRepository extends ReactiveCrudRepository<Event, Long> {
}
