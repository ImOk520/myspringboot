package com.feng.config;

import com.feng.filter.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feng, Ge 2020-10-20 16:24
 */
@Configuration
public class FilterConfig {

    @Bean
    Filter getFilterBean(){
        return new Filter();
    }
}
