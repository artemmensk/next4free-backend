package com.artemmensk.next4free.domain;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ClientName {
    private String value;

    public static ClientName from(String raw) {
        return new ClientName() {{
            setValue(raw);
        }};
    }
}
