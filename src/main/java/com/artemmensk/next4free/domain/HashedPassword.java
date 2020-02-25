package com.artemmensk.next4free.domain;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class HashedPassword {
    private String value;

    public static HashedPassword from(String raw) {
        return new HashedPassword() {{
            setValue(raw);
        }};
    }
}
