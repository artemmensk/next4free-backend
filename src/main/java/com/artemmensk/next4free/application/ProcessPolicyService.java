package com.artemmensk.next4free.application;

import com.artemmensk.next4free.domain.AmountOfStampsProcessPolicy;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ProcessPolicy;

public class ProcessPolicyService {
    ProcessPolicy findByBusiness(BusinessId businessId) {
        return new AmountOfStampsProcessPolicy(3);
    }
}
