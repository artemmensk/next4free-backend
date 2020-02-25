package com.artemmensk.next4free.domain;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class AccountId {
    private String value;

    public static AccountId from(String raw) {
        return new AccountId() {{
            setValue(raw);
        }};
    }

}
