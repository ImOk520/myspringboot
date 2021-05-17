package config.beanAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Feng, Ge 2021/5/12 0012 18:12
 */
@Configuration
public class BeanLifeConfig01 {

    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Person getPerson(){
        return new Person();
    }
}
