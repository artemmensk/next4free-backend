package com.artemmensk.next4free.domain;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class BusinessId {
    private String value;

    public static BusinessId from(String raw) {
        return new BusinessId() {{
            setValue(raw);
        }};
    }
}
