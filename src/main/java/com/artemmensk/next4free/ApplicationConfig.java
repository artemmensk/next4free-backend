package com.artemmensk.next4free;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artemmensk.next4free.application.CollectingProcessPolicyService;
import com.artemmensk.next4free.application.CollectingProcessService;
import com.artemmensk.next4free.domain.CollectingProcessId;
import com.artemmensk.next4free.domain.CollectingProcessRepository;
import com.artemmensk.next4free.domain.StampId;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final CollectingProcessRepository collectingProcessRepository;
    private final Supplier<CollectingProcessId> collectingProcessIdSupplier;
    private final Supplier<LocalDateTime> localDateTimeSupplier;
    private final Supplier<StampId> stampIdSupplier;

    @Bean
    public CollectingProcessService collectingProcessService() {
        return new CollectingProcessService(
                collectingProcessRepository,
                collectingProcessPolicyService(),
                collectingProcessIdSupplier,
                localDateTimeSupplier,
                stampIdSupplier
        );
    }

    @Bean
    public CollectingProcessPolicyService collectingProcessPolicyService() {
        return new CollectingProcessPolicyService();
    }
}
