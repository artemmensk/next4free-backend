package com.artemmensk.next4free.adapter.rest.collectingprocess;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class StampDto {
    String stampId;
    LocalDateTime createdOn;
}
