package com.artemmensk.next4free.application;

import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;

class ProcessNotFound extends RuntimeException {

    ProcessNotFound(
            ClientId clientId,
            BusinessId businessId) {
        super(String.format("Not found process for %s and %s", clientId, businessId));
    }
}
