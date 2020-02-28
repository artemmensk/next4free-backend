package com.artemmensk.next4free.domain;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ClientId {
    private String value;

    public static ClientId from(String raw) {
        return new ClientId() {{
            setValue(raw);
        }};
    }
}
