package com.artemmensk.next4free.adapter.rest.collectingprocess;

import java.util.stream.Collectors;

import com.artemmensk.next4free.domain.collectingprocess.CollectingProcess;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CollectingProcessMapper {

    private final StampMapper stampMapper;

    public CollectingProcessDto map(CollectingProcess collectingProcess) {
        return CollectingProcessDto.builder()
                .businessId(collectingProcess.getBusinessId().getValue())
                .clientId(collectingProcess.getClientId().getValue())
                .collectingProcessPolicy(collectingProcess.getCollectingProcessPolicy())
                .stamps(collectingProcess.getStamps().stream().map(stampMapper::map).collect(Collectors.toSet()))
                .build();
    }
}
