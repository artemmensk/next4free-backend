package com.artemmensk.next4free.domain;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Email {
    private String value;

    public static Email from(String raw) {
        return new Email() {{
            setValue(raw);
        }};
    }
}
