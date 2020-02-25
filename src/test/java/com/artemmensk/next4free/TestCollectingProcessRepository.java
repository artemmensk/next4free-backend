package com.artemmensk.next4free;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.CollectingProcess;
import com.artemmensk.next4free.domain.CollectingProcessId;
import com.artemmensk.next4free.domain.CollectingProcessRepository;

public enum TestCollectingProcessRepository implements CollectingProcessRepository {
    INSTANCE;

    final Map<CollectingProcessId, CollectingProcess> collectingProcesses = new HashMap<>();

    @Override
    public CollectingProcess save(CollectingProcess collectingProcess) {
        return collectingProcesses.put(collectingProcess.getCollectingProcessId(), collectingProcess);
    }

    @Override
    public Optional<CollectingProcess> findByBusinessIdAndClientIdAndCompletedIsNull(
            BusinessId businessId,
            ClientId clientId) {
        return collectingProcesses.values().stream()
                .filter(p -> p.getBusinessId().equals(businessId))
                .filter(p -> p.getClientId().equals(clientId))
                .findAny();
    }
}
