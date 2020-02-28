package com.artemmensk.next4free.domain;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class BusinessName {
    private String value;

    public static BusinessName from(String raw) {
        return new BusinessName() {{
            setValue(raw);
        }};
    }
}
