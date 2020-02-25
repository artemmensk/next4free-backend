package com.artemmensk.next4free.infra.hashing;

import com.artemmensk.next4free.application.hashing.HashingService;
import com.artemmensk.next4free.domain.HashedPassword;
import com.artemmensk.next4free.domain.Password;

public class BcryptHashingService implements HashingService {
    @Override
    public HashedPassword hash(Password password) {
        return HashedPassword.from(password.getValue() + "__hashed");
    }
}
