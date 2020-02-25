package com.artemmensk.next4free.application.authentication;

import com.artemmensk.next4free.domain.Account;
import com.artemmensk.next4free.domain.AccountRepository;
import com.artemmensk.next4free.domain.Email;
import com.artemmensk.next4free.domain.Password;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticationService {

    private final AccountRepository accountRepository;
    private final PasswordVerifier passwordVerifier;
    private final TokenService tokenService;

    public Token authenticate(Email email, Password password) {
        final Account account = accountRepository.findByEmail(email).orElseThrow(() -> accountNotFound(email));

        account.assertPasswordIsCorrect(passwordVerifier, password);

        return tokenService.generateToken(account);
    }

    private RuntimeException accountNotFound(Email email) {
        return new RuntimeException(String.format("account for %s not found", email));
    }
}
