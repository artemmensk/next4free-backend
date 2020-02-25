package com.artemmensk.next4free.adapter.rest.collectingprocess;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.artemmensk.next4free.application.CollectingProcessService;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.CollectingProcess;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CollectingProcessResource {

    private final CollectingProcessService collectingProcessService;
    private final CollectingProcessMapper mapper;

    @GetMapping("/client/{clientId}/business/{businessId}/current-process")
    public CollectingProcessDto getCurrentProcess(
            @PathVariable String clientId,
            @PathVariable String businessId) {
        final CollectingProcess currentCollectingProcess =
                collectingProcessService.getCurrentProcess(BusinessId.from(businessId), ClientId.from(clientId));
        return mapper.map(currentCollectingProcess);
    }

}
