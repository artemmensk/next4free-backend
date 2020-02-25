package com.artemmensk.next4free.application.registration;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artemmensk.next4free.application.hashing.HashingService;
import com.artemmensk.next4free.domain.AccountId;
import com.artemmensk.next4free.domain.AccountRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RegistrationConfig {

    private final AccountRepository accountRepository;
    private final HashingService hashingService;
    private final Supplier<AccountId> accountIdSupplier;

    @Bean
    RegistrationService registrationService() {
        return new RegistrationService(accountRepository, hashingService, accountIdSupplier);
    }
}
