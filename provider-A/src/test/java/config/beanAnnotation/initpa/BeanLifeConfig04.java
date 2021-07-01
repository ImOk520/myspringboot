package config.beanAnnotation.initpa;

import org.springframework.context.annotation.Bean;

public class BeanLifeConfig04 {
    @Bean
    public Person getPerson(){
        return new Person();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }
}
