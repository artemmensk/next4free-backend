package com.artemmensk.next4free.application;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.Process;
import com.artemmensk.next4free.domain.ProcessId;
import com.artemmensk.next4free.domain.ProcessPolicy;
import com.artemmensk.next4free.domain.ProcessRepository;
import com.artemmensk.next4free.domain.Stamp;
import com.artemmensk.next4free.domain.StampId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProcessService {

    private final ProcessRepository processRepository;
    private final ProcessPolicyService processPolicyService;
    private final Supplier<ProcessId> processIdSupplier;
    private final Supplier<LocalDateTime> localDateTimeSupplier;
    private final Supplier<StampId> stampIdSupplier;

    public void stamp(
            BusinessId businessId,
            ClientId clientId) {

        final Process process = processRepository.findByBusinessIdAndClientIdAndCompletedIsNull(businessId, clientId)
                .orElseGet(() -> createNewProcess(businessId, clientId));

        process.stamp(createNewStamp());
        processRepository.save(process);
    }

    public void complete(
            BusinessId businessId,
            ClientId clientId) {

        final Process process = processRepository.findByBusinessIdAndClientIdAndCompletedIsNull(businessId, clientId)
                .orElseThrow(() -> new RuntimeException("process not found"));

        final LocalDateTime completedOn = localDateTimeSupplier.get();
        process.complete(completedOn);
        processRepository.save(process);
    }

    private Stamp createNewStamp() {
        final StampId stampId = stampIdSupplier.get();
        final LocalDateTime createdOn = localDateTimeSupplier.get();

        return new Stamp(stampId, createdOn);
    }

    private Process createNewProcess(
            BusinessId businessId,
            ClientId clientId) {
        final ProcessId processId = processIdSupplier.get();
        final ProcessPolicy processPolicy = processPolicyService.findByBusiness(businessId);
        final LocalDateTime createdOn = localDateTimeSupplier.get();

        return Process.create(
                processId,
                clientId,
                businessId,
                processPolicy,
                createdOn);
    }

    public Process getCurrentProcess(BusinessId businessId, ClientId clientId) {
        return processRepository.findByBusinessIdAndClientIdAndCompletedIsNull(businessId, clientId)
                .orElseThrow(() -> new ProcessNotFound(clientId, businessId));
    }
}
