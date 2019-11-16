package com.artemmensk.next4free.adapter.rest;

import java.util.stream.Collectors;

import com.artemmensk.next4free.domain.Process;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProcessMapper {

    private final StampMapper stampMapper;

    public ProcessDto map(Process process) {
        return ProcessDto.builder()
                .businessId(process.getBusinessId().getValue())
                .clientId(process.getClientId().getValue())
                .processPolicy(process.getProcessPolicy())
                .stamps(process.getStamps().stream().map(stampMapper::map).collect(Collectors.toSet()))
                .build();
    }
}
