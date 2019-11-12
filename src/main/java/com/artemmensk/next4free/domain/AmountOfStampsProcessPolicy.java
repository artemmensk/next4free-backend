package com.artemmensk.next4free.domain;

import lombok.Value;

@Value
public class AmountOfStampsProcessPolicy implements ProcessPolicy {

    int targetAmount;

    public void assertSatisfied(Process process) {
        final int currentAmount = process.getStamps().size();

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
