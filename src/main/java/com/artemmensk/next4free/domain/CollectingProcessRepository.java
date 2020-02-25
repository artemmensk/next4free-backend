package com.artemmensk.next4free.domain;

import java.util.Optional;

public interface CollectingProcessRepository {
    CollectingProcess save(CollectingProcess collectingProcess);

    Optional<CollectingProcess> findByBusinessIdAndClientIdAndCompletedIsNull(
            BusinessId businessId,
            ClientId clientId);
}
