package com.artemmensk.next4free.application.collectingprocess;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artemmensk.next4free.domain.StampId;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcessId;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcessRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CollectingProcessConfig {

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
