package com.artemmensk.next4free.domain;

import org.springframework.data.annotation.Id;

import lombok.Value;

@Value
public class Client {
    @Id
    ClientId clientId;
    String firstName;
    String surname;
}
