package com.artemmensk.next4free;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artemmensk.next4free.domain.AccountId;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.StampId;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcessId;

@Configuration
public class SupplierConfig {

    private final ZoneId zoneId = ZoneId.systemDefault();

    @Bean
    Supplier<LocalDateTime> localDateTimeSupplier() {
        return LocalDateTime::now;
    }

    @Bean
    Supplier<Date> dateSupplier() {
        return () -> Date.from(localDateTimeSupplier().get().atZone(zoneId).toInstant());
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
        return () -> ClientId.from(UUID.randomUUID().toString());
    }

    @Bean
    Supplier<BusinessId> businessIdSupplier() {
        return () -> BusinessId.from(UUID.randomUUID().toString());
    }

    @Bean
    Supplier<AccountId> accountIdSupplier() {
        return () -> AccountId.from(UUID.randomUUID().toString());
    }
}
