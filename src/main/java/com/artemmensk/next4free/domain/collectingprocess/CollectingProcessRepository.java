package com.artemmensk.next4free.domain.collectingprocess;

import java.util.Optional;
import java.util.stream.Stream;

import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;

public interface CollectingProcessRepository {
    CollectingProcess save(CollectingProcess collectingProcess);

    Optional<CollectingProcess> findByBusinessIdAndClientIdAndCompletedIsNull(
            BusinessId businessId,
            ClientId clientId);

    Stream<CollectingProcess> findAllByClientId(ClientId clientId);

    Stream<CollectingProcess> findAllByClientIdAndCompletedIsNull(ClientId clientId);

    Stream<CollectingProcess> findAllByBusinessId(BusinessId businessId);
}
