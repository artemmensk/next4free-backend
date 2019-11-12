package com.artemmensk.next4free.domain;

import lombok.Value;

@Value
public class ProcessId {
    String value;

    public static ProcessId from(String raw) {
        return new ProcessId(raw);
    }
}
