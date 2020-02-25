package com.artemmensk.next4free.adapter.rest.registration;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
class RegistrationRequest {
    @NotNull String email;
    @NotNull String password;
}
