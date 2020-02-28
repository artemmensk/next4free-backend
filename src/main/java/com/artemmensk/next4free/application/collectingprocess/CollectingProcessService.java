package com.artemmensk.next4free.application.collectingprocess;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcess;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcessId;
import com.artemmensk.next4free.domain.CollectingProcessPolicy;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcessRepository;
import com.artemmensk.next4free.domain.Stamp;
import com.artemmensk.next4free.domain.StampId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CollectingProcessService {

    private final CollectingProcessRepository collectingProcessRepository;
    private final CollectingProcessPolicyService collectingProcessPolicyService;
    private final Supplier<CollectingProcessId> collectingProcessIdSupplier;
    private final Supplier<LocalDateTime> localDateTimeSupplier;
    private final Supplier<StampId> stampIdSupplier;

    public void stamp(
            BusinessId businessId,
            ClientId clientId) {

        final CollectingProcess collectingProcess = collectingProcessRepository
                .findByBusinessIdAndClientIdAndCompletedIsNull(businessId, clientId)
                .orElseGet(() -> createNewProcess(businessId, clientId));

        collectingProcess.stamp(createNewStamp());
        collectingProcessRepository.save(collectingProcess);
    }

    public void complete(
            BusinessId businessId,
            ClientId clientId) {

        final CollectingProcess collectingProcess = collectingProcessRepository
                .findByBusinessIdAndClientIdAndCompletedIsNull(businessId, clientId)
                .orElseThrow(() -> new RuntimeException("process not found"));

        final LocalDateTime completedOn = localDateTimeSupplier.get();
        collectingProcess.complete(completedOn);
        collectingProcessRepository.save(collectingProcess);
    }

    private Stamp createNewStamp() {
        final StampId stampId = stampIdSupplier.get();
        final LocalDateTime createdOn = localDateTimeSupplier.get();

        return new Stamp(stampId, createdOn);
    }

    private CollectingProcess createNewProcess(
            BusinessId businessId,
            ClientId clientId) {
        final CollectingProcessId collectingProcessId = collectingProcessIdSupplier.get();
        final CollectingProcessPolicy collectingProcessPolicy = collectingProcessPolicyService
                .findByBusiness(businessId);
        final LocalDateTime createdOn = localDateTimeSupplier.get();

        return CollectingProcess.create(
                collectingProcessId,
                clientId,
                businessId,
                collectingProcessPolicy,
                createdOn);
    }

    public CollectingProcess getCurrentProcess(
            BusinessId businessId,
            ClientId clientId) {
        return collectingProcessRepository.findByBusinessIdAndClientIdAndCompletedIsNull(businessId, clientId)
                .orElseThrow(() -> new CollectingProcessNotFound(clientId, businessId));
    }

    public Stream<CollectingProcess> getCurrentProcessesForClient(ClientId clientId) {
        return collectingProcessRepository.findAllByClientIdAndCompletedIsNull(clientId);
    }
}
