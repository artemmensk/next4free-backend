package com.artemmensk.next4free.adapter.rest.collectingprocess;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
class StampRequest {
    @NotNull String businessId;
    @NotNull String clientId;
}
