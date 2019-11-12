package com.artemmensk.next4free.domain;

public interface ProcessPolicy {
    void assertSatisfied(Process process);
}
