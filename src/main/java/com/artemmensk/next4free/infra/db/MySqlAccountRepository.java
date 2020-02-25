package com.artemmensk.next4free.infra.db;

import org.springframework.data.repository.CrudRepository;

import com.artemmensk.next4free.domain.Account;
import com.artemmensk.next4free.domain.AccountRepository;

public interface MySqlAccountRepository extends AccountRepository, CrudRepository<Account, Long> {
}
