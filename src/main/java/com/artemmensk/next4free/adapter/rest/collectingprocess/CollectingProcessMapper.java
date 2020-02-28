package com.artemmensk.next4free.adapter.rest.collectingprocess;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.artemmensk.next4free.domain.collectingprocess.CollectingProcess;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CollectingProcessMapper {

    private final StampMapper stampMapper;

    public Stream<CollectingProcessDto> map(Stream<CollectingProcess> collectingProcess) {
        return collectingProcess.map(this::map);
    }

    public CollectingProcessDto map(CollectingProcess collectingProcess) {
        return CollectingProcessDto.builder()
                .businessId(collectingProcess.getBusinessId().getValue())
                .clientId(collectingProcess.getClientId().getValue())
                .collectingProcessPolicy(collectingProcess.getCollectingProcessPolicy())
                .stamps(collectingProcess.getStamps().stream().map(stampMapper::map).collect(Collectors.toSet()))
                .build();
    }
}
