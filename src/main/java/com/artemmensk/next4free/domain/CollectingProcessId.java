package com.artemmensk.next4free.domain;

import lombok.Value;

@Value
public class CollectingProcessId {
    String value;

    public static CollectingProcessId from(String raw) {
        return new CollectingProcessId(raw);
    }
}
