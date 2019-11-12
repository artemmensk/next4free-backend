package com.artemmensk.next4free.adapter.rest;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
class Request {
    @NotNull String businessId;
    @NotNull String clientId;
}
