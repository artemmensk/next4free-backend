package com.artemmensk.next4free.adapter.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.artemmensk.next4free.application.ProcessService;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;
import com.artemmensk.next4free.domain.Process;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ClientResource {

    private final ProcessService processService;
    private final ProcessMapper mapper;

    @GetMapping("/client/{clientId}/business/{businessId}/current-process")
    public ProcessDto getCurrentProcess(
            @PathVariable String clientId,
            @PathVariable String businessId) {
        final Process currentProcess =
                processService.getCurrentProcess(BusinessId.from(businessId), ClientId.from(clientId));
        return mapper.map(currentProcess);
    }

}
