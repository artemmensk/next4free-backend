package com.artemmensk.next4free.domain;

import lombok.Value;

@Value
public class StampId {
    String value;

    public static StampId from(String raw) {
        return new StampId(raw);
    }
}
