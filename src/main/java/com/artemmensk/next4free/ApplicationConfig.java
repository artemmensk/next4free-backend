package com.artemmensk.next4free;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artemmensk.next4free.application.ProcessPolicyService;
import com.artemmensk.next4free.application.ProcessService;
import com.artemmensk.next4free.domain.ProcessId;
import com.artemmensk.next4free.domain.ProcessRepository;
import com.artemmensk.next4free.domain.StampId;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final ProcessRepository processRepository;
    private final Supplier<ProcessId> processIdSupplier;
    private final Supplier<LocalDateTime> localDateTimeSupplier;
    private final Supplier<StampId> stampIdSupplier;

    @Bean
    public ProcessService processService() {
        return new ProcessService(
                processRepository,
                processPolicyService(),
                processIdSupplier,
                localDateTimeSupplier,
                stampIdSupplier
        );
    }

    @Bean
    public ProcessPolicyService processPolicyService() {
        return new ProcessPolicyService();
    }
}
