package com.artemmensk.next4free.application.hashing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artemmensk.next4free.infra.hashing.BcryptHashingService;

@Configuration
public class HashingConfig {
    @Bean
    HashingService hashingService() {
        return new BcryptHashingService();
    }
}
