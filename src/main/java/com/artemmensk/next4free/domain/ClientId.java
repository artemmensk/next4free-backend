package com.artemmensk.next4free.domain;

import lombok.Value;

@Value
public class ClientId {
    String value;

    public static ClientId from(String raw) {
        return new ClientId(raw);
    }
}
