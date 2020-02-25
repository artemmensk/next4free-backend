package com.artemmensk.next4free.domain.collectingprocess;

import java.util.Optional;

import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;

public interface CollectingProcessRepository {
    CollectingProcess save(CollectingProcess collectingProcess);

    Optional<CollectingProcess> findByBusinessIdAndClientIdAndCompletedIsNull(
            BusinessId businessId,
            ClientId clientId);
}
