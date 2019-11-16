package com.artemmensk.next4free;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.Process;
import com.artemmensk.next4free.domain.ProcessId;
import com.artemmensk.next4free.domain.ProcessRepository;

public enum TestProcessRepository implements ProcessRepository {
    INSTANCE;

    final Map<ProcessId, Process> processes = new HashMap<>();

    @Override
    public Process save(Process process) {
        return processes.put(process.getProcessId(), process);
    }

    @Override
    public Optional<Process> findByBusinessIdAndClientIdAndCompletedIsNull(
            BusinessId businessId,
            ClientId clientId) {
        return processes.values().stream()
                .filter(p -> p.getBusinessId().equals(businessId))
                .filter(p -> p.getClientId().equals(clientId))
                .findAny();
    }
}
