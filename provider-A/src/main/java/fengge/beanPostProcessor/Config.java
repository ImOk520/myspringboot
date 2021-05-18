package fengge.beanPostProcessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feng, Ge 2021/5/14 0014 17:28
 */
@Configuration
public class Config {

//    @Bean
//    public Person person(){
//        return new Person();
//    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }
}
