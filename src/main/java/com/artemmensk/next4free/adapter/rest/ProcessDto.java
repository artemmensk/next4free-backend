package com.artemmensk.next4free.adapter.rest;

import java.util.Set;

import com.artemmensk.next4free.domain.ProcessPolicy;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ProcessDto {
    String clientId;
    String businessId;
    ProcessPolicy processPolicy;
    Set<StampDto> stamps;
}
