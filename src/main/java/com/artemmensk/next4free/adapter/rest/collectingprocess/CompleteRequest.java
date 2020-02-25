package com.artemmensk.next4free.adapter.rest.collectingprocess;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
public class CompleteRequest {
    @NotNull String businessId;
    @NotNull String clientId;
}
