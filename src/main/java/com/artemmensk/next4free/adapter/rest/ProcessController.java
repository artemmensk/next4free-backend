package com.artemmensk.next4free.adapter.rest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.artemmensk.next4free.application.ProcessService;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProcessController {

    private final ProcessService processService;

    @PutMapping("/process/stamp")
    public void stamp(@RequestBody @Validated Request request) {
        final BusinessId businessId = BusinessId.from(request.getBusinessId());
        final ClientId clientId = ClientId.from(request.getClientId());

        processService.stamp(businessId, clientId);
    }

    @PutMapping("/process/complete")
    public void complete(@RequestBody @Validated Request request) {
        final BusinessId businessId = BusinessId.from(request.getBusinessId());
        final ClientId clientId = ClientId.from(request.getClientId());

        processService.complete(businessId, clientId);
    }
}
