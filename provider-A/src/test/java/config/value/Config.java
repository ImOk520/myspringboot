package config.value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feng, Ge 2021/5/17 0017 9:02
 */
@Configuration
public class Config {

    @Bean
    public Person person(){
        return new Person();
    }
}
