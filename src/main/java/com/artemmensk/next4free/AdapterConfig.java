package com.artemmensk.next4free;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artemmensk.next4free.adapter.rest.ProcessMapper;
import com.artemmensk.next4free.adapter.rest.StampMapper;

@Configuration
public class AdapterConfig {

    @Bean
    public ProcessMapper processMapper() {
        return new ProcessMapper(stampMapper());
    }

    @Bean
    public StampMapper stampMapper() {
        return new StampMapper();
    }
}
