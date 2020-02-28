package com.artemmensk.next4free.application.authentication;

import java.util.Date;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artemmensk.next4free.application.hashing.HashingService;
import com.artemmensk.next4free.domain.AccountRepository;
import com.artemmensk.next4free.infra.token.JwtTokenService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AuthenticationConfig {

    private final AccountRepository accountRepository;
    private final HashingService hashingService;
    private final Supplier<Date> dateSupplier;

    @Bean
    AuthenticationService authenticationService() {
        return new AuthenticationService(accountRepository, passwordVerifierService(),tokenService());
    }

    private PasswordVerifier passwordVerifierService() {
        return new SimplePasswordVerifier(hashingService);
    }

    private TokenService tokenService() {
        return new JwtTokenService(dateSupplier);
    }
}
