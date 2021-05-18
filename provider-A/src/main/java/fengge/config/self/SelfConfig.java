package fengge.config.self;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feng, Ge 2021/5/18 0018 18:43
 */
@Configuration
public class SelfConfig {

    @Bean
    public Ship person(){
        return new Ship();
    }
}
