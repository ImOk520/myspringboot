package fengge.beanPostProcessor;

import fengge.beanPostProcessor.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feng, Ge 2021/5/12 0012 18:12
 */
@Configuration
public class BeanLifeConfig02 {

    @Bean
    public Person getPerson(){
        return new Person();
    }
}
