package com.artemmensk.next4free.adapter.rest.statistics;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcess;
import com.artemmensk.next4free.domain.collectingprocess.CollectingProcessRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StatisticsResource {

    private final CollectingProcessRepository collectingProcessRepository;
    private final StatisticsMapper mapper;

    @GetMapping("/client/{clientId}/stats")
    public ClientStatisticsDto getStatisticsForClient(@PathVariable String clientId) {
        final List<CollectingProcess> collectingProcesses =
                collectingProcessRepository.findAllByClientId(ClientId.from(clientId)).collect(toList());

        return mapper.mapToClientStats(collectingProcesses);
    }

    @GetMapping("/business/{businessId}/stats")
    public ClientStatisticsDto getStatisticsForBusiness(@PathVariable String businessId) {
        final List<CollectingProcess> collectingProcesses =
                collectingProcessRepository.findAllByBusinessId(BusinessId.from(businessId)).collect(toList());

        return mapper.mapToClientStats(collectingProcesses);
    }

}
