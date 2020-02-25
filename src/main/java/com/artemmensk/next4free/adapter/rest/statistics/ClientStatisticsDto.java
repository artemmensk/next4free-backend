package com.artemmensk.next4free.adapter.rest.statistics;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
class ClientStatisticsDto {
    LocalDateTime firstStampCollectedOn;
    LocalDateTime lastStampCollectedOn;
    long numberOfBusinesses;
    int numberOfCollectedStamps;
    long numberOfCompletedCollectingProcesses;
}
