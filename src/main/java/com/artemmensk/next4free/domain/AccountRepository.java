package com.artemmensk.next4free.domain;

import java.util.Optional;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findByEmail(Email email);
}
