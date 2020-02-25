package com.artemmensk.next4free.adapter.rest.collectingprocess;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.artemmensk.next4free.application.collectingprocess.CollectingProcessService;
import com.artemmensk.next4free.domain.BusinessId;
import com.artemmensk.next4free.domain.ClientId;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CollectingProcessController {

    private final CollectingProcessService collectingProcessService;

    @PutMapping("/process/stamp")
    public void stamp(@RequestBody @Validated StampRequest request) {
        final BusinessId businessId = BusinessId.from(request.getBusinessId());
        final ClientId clientId = ClientId.from(request.getClientId());

        collectingProcessService.stamp(businessId, clientId);
    }

    @PutMapping("/process/complete")
    public void complete(@RequestBody @Validated CompleteRequest request) {
        final BusinessId businessId = BusinessId.from(request.getBusinessId());
        final ClientId clientId = ClientId.from(request.getClientId());

        collectingProcessService.complete(businessId, clientId);
    }
}
