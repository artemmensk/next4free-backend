package com.artemmensk.next4free.application.collectingprocess;

import com.artemmensk.next4free.domain.AmountOfStampsCollectingProcessPolicy;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.CollectingProcessPolicy;

public class CollectingProcessPolicyService {
    CollectingProcessPolicy findByBusiness(BusinessId businessId) {
        return new AmountOfStampsCollectingProcessPolicy(3);
    }
}
