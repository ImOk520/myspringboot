package fengge.config.value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Feng, Ge 2021/5/17 0017 9:02
 */
@PropertySource(value = {"classpath:/application.yml"})
@Configuration
public class Config01 {

    @Bean("person-value")
    public Person person(){
        return new Person();
    }

    @Bean("person-value01")
    public Person01 person01(){
        return new Person01();
    }
}
