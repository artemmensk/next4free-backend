package com.artemmensk.next4free.adapter.rest.collectingprocess;

import java.util.Set;

import com.artemmensk.next4free.domain.CollectingProcessPolicy;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CollectingProcessDto {
    String clientId;
    String businessId;
    CollectingProcessPolicy collectingProcessPolicy;
    Set<StampDto> stamps;
}
