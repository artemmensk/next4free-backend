package com.artemmensk.next4free.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.Value;

@Value
public class Stamp {
    @Id
    StampId stampId;
    LocalDateTime createdOn;

    public static Stamp create(
            StampId stampId,
            LocalDateTime createdOn) {
        return new Stamp(stampId, createdOn);
    }
}
