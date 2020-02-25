package com.artemmensk.next4free.adapter.rest.statistics;

import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import com.artemmensk.next4free.domain.Stamp;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcess;

class StatisticsMapper {
    ClientStatisticsDto mapToClientStats(List<CollectingProcess> collectingProcesses) {

        final List<Stamp> stamps = collectingProcesses.stream()
                .map(CollectingProcess::getStamps)
                .flatMap(Collection::stream)
                .collect(toList());

        final LocalDateTime firstStampCollectedOn = findFirstStampCollectedOn(stamps);
        final LocalDateTime lastStampCollectedOn = findLastStampCollectedOn(stamps);
        final int numberOfCollectedStamps = stamps.size();
        final long numberOfBusinesses = computeNumberOfBusinesses(collectingProcesses);
        final long numberOfCompletedCollectingProcesses =
                computeNumberOfCompletedCollectingProcesses(collectingProcesses);

        return ClientStatisticsDto.builder()
                .firstStampCollectedOn(firstStampCollectedOn)
                .numberOfBusinesses(numberOfBusinesses)
                .lastStampCollectedOn(lastStampCollectedOn)
                .numberOfCollectedStamps(numberOfCollectedStamps)
                .numberOfCompletedCollectingProcesses(numberOfCompletedCollectingProcesses)
                .build();
    }

    BusinessStatisticsDto mapToBusinessStats(List<CollectingProcess> collectingProcesses) {

        final List<Stamp> stamps = collectingProcesses.stream()
                .map(CollectingProcess::getStamps)
                .flatMap(Collection::stream)
                .collect(toList());

        final LocalDateTime firstStampCollectedOn = findFirstStampCollectedOn(stamps);
        final LocalDateTime lastStampCollectedOn = findLastStampCollectedOn(stamps);
        final long numberOfClients = computeNumberOfClients(collectingProcesses);
        final int numberOfCollectedStamps = stamps.size();
        final long numberOfCompletedCollectingProcesses =
                computeNumberOfCompletedCollectingProcesses(collectingProcesses);

        return BusinessStatisticsDto.builder()
                .firstStampCollectedOn(firstStampCollectedOn)
                .lastStampCollectedOn(lastStampCollectedOn)
                .numberOfCollectedStamps(numberOfCollectedStamps)
                .numberOfCompletedCollectingProcesses(numberOfCompletedCollectingProcesses)
                .numberOfClients(numberOfClients)
                .build();
    }

    private long computeNumberOfClients(List<CollectingProcess> collectingProcesses) {
        return collectingProcesses.stream()
                .map(CollectingProcess::getClientId)
                .distinct()
                .count();
    }

    private long computeNumberOfBusinesses(List<CollectingProcess> collectingProcesses) {
        return collectingProcesses.stream()
                .map(CollectingProcess::getBusinessId)
                .distinct()
                .count();
    }

    private LocalDateTime findLastStampCollectedOn(List<Stamp> stamps) {
        return stamps.stream()
                .reduce((left, right) -> left.getCreatedOn().isAfter(right.getCreatedOn()) ? left : right)
                .map(Stamp::getCreatedOn)
                .orElse(null);
    }

    private LocalDateTime findFirstStampCollectedOn(List<Stamp> stamps) {
        return stamps.stream()
                .reduce((left, right) -> left.getCreatedOn().isBefore(right.getCreatedOn()) ? left : right)
                .map(Stamp::getCreatedOn)
                .orElse(null);
    }

    private long computeNumberOfCompletedCollectingProcesses(List<CollectingProcess> collectingProcesses) {
        return collectingProcesses.stream()
                .map(CollectingProcess::getCompleted)
                .filter(Objects::nonNull)
                .count();
    }
}
