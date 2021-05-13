package config.beanLife.beanAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feng, Ge 2021/5/12 0012 18:12
 */
@Configuration
public class BeanLifeConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Person getMyPerson(){
        return new Person();
    }
}
