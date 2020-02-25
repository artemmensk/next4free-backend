package com.artemmensk.next4free;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artemmensk.next4free.domain.AccountId;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcessId;
import com.artemmensk.next4free.domain.StampId;

@Configuration
public class SupplierConfig {

    @Bean
    Supplier<LocalDateTime> localDateTimeSupplier() {
        return LocalDateTime::now;
    }

    @Bean
    Supplier<CollectingProcessId> collectingProcessIdSupplier() {
        return () -> new CollectingProcessId(UUID.randomUUID().toString());
    }

    @Bean
    Supplier<StampId> stampIdSupplier() {
        return () -> new StampId(UUID.randomUUID().toString());
    }

    @Bean
    Supplier<ClientId> clientIdSupplier() {
        return () -> new ClientId(UUID.randomUUID().toString());
    }

    @Bean
    Supplier<BusinessId> businessIdSupplier() {
        return () -> new BusinessId(UUID.randomUUID().toString());
    }

    @Bean
    Supplier<AccountId> accountIdSupplier() {
        return () -> AccountId.from(UUID.randomUUID().toString());
    }
}
