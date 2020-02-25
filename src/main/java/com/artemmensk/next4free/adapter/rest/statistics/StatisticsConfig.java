package com.artemmensk.next4free.adapter.rest.statistics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StatisticsConfig {
    @Bean
    StatisticsMapper clientStatisticsMapper() {
        return new StatisticsMapper();
    }
}
