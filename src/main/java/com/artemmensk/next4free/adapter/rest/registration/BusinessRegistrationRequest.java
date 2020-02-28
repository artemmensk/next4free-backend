package com.artemmensk.next4free.adapter.rest.registration;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
class BusinessRegistrationRequest {
    @NotNull String email;
    @NotNull String password;
    @NotNull String businessName;
}
