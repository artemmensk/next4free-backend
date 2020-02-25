package com.artemmensk.next4free.application;

import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;

class CollectingProcessNotFound extends RuntimeException {

    CollectingProcessNotFound(
            ClientId clientId,
            BusinessId businessId) {
        super(String.format("Not found collecting process for %s and %s", clientId, businessId));
    }
}
