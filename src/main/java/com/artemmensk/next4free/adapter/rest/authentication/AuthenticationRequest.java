package com.artemmensk.next4free.adapter.rest.authentication;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
class AuthenticationRequest {
    @NotNull String email;
    @NotNull String password;

    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                "email='" + email + '\'' +
                ", password='*****'" +
                '}';
    }
}
