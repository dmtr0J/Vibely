package com.vibely.account.query.repositories;

import com.vibely.common.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountReadRepository extends ReactiveCrudRepository<Account, Long> {
}
