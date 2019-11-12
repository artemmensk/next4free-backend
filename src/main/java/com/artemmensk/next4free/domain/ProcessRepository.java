package com.artemmensk.next4free.domain;

import java.util.Optional;

public interface ProcessRepository {
    Process save(Process process);

    Optional<Process> findByBusinessIdAndClientIdAndCompletedIsNull(
            BusinessId businessId,
            ClientId clientId);
}
