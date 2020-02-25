package com.artemmensk.next4free.adapter.rest.statistics;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
class BusinessStatisticsDto {
    LocalDateTime firstStampCollectedOn;
    LocalDateTime lastStampCollectedOn;
    long numberOfClients;
    int numberOfCollectedStamps;
    long numberOfCompletedCollectingProcesses;
}
