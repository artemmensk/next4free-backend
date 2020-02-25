package com.artemmensk.next4free.domain;

import com.artemmensk.next4free.domain.collectingprocess.CollectingProcess;

import lombok.Value;

@Value
public class AmountOfStampsCollectingProcessPolicy implements CollectingProcessPolicy {

    int targetAmount;

    public void assertSatisfied(CollectingProcess collectingProcess) {
        final int currentAmount = collectingProcess.getStamps().size();

        if (enoughStamps(currentAmount)) {
            return;
        }

        throw new RuntimeException(String.format(
                "Not enough stamps: currentAmount = %s vs. targetAmount = %s",
                currentAmount, targetAmount));
    }

    private boolean enoughStamps(int currentAmount) {
        return currentAmount >= targetAmount;
    }
}
