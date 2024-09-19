package com.vibely.account.repositories;

import com.vibely.common.entity.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountReadRepository extends ReactiveCrudRepository<Account, Long> {
}
