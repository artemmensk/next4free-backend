package com.artemmensk.next4free.domain;

import lombok.Value;

@Value
public class BusinessId {
    String value;

    public static BusinessId from(String raw) {
        return new BusinessId(raw);
    }
}
