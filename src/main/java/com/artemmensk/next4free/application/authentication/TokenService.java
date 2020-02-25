package com.artemmensk.next4free.application.authentication;

import com.artemmensk.next4free.domain.Account;

public interface TokenService {
    Token generateToken(Account account);
}
