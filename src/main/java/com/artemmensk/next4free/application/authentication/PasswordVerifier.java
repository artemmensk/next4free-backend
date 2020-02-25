package com.artemmensk.next4free.application.authentication;

import com.artemmensk.next4free.domain.HashedPassword;
import com.artemmensk.next4free.domain.Password;

public interface PasswordVerifier {
    void assertPasswordIsCorrect(Password passedPassword, HashedPassword hashedPassword);
}
