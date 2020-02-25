package com.artemmensk.next4free.application.authentication;

import com.artemmensk.next4free.application.hashing.HashingService;
import com.artemmensk.next4free.domain.HashedPassword;
import com.artemmensk.next4free.domain.Password;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SimplePasswordVerifier implements PasswordVerifier {

    private final HashingService hashingService;

    public void assertPasswordIsCorrect(
            Password passedPassword,
            HashedPassword hashedPassword) {
        final HashedPassword passedPasswordHash = hashingService.hash(passedPassword);
        if (hashedPassword.equals(passedPasswordHash)) {
            return;
        }
        throw new RuntimeException("Password incorrect");
    }
}
