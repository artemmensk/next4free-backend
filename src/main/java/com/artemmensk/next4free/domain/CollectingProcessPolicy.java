package com.artemmensk.next4free.domain;

import com.artemmensk.next4free.domain.collectingprocess.CollectingProcess;

public interface CollectingProcessPolicy {
    void assertSatisfied(CollectingProcess collectingProcess);
}
