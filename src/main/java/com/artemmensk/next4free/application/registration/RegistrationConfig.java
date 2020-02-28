package com.artemmensk.next4free.application.registration;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artemmensk.next4free.application.hashing.HashingService;
import com.artemmensk.next4free.domain.AccountId;
import com.artemmensk.next4free.domain.AccountRepository;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.BusinessRepository;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.ClientRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RegistrationConfig {

    private final AccountRepository accountRepository;
    private final BusinessRepository businessRepository;
    private final ClientRepository clientRepository;
    private final HashingService hashingService;
    private final Supplier<AccountId> accountIdSupplier;
    private final Supplier<BusinessId> businessIdSupplier;
    private final Supplier<ClientId> clientIdSupplier;

    @Bean
    RegistrationService registrationService() {
        return new RegistrationService(accountRepository, businessRepository, clientRepository, hashingService,
                accountIdSupplier, businessIdSupplier, clientIdSupplier);
    }
}
