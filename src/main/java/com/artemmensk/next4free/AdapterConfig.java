package com.artemmensk.next4free;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artemmensk.next4free.adapter.rest.collectingprocess.CollectingProcessMapper;
import com.artemmensk.next4free.adapter.rest.collectingprocess.StampMapper;

@Configuration
public class AdapterConfig {

    @Bean
    public CollectingProcessMapper collectingProcessMapper() {
        return new CollectingProcessMapper(stampMapper());
    }

    @Bean
    public StampMapper stampMapper() {
        return new StampMapper();
    }
}
