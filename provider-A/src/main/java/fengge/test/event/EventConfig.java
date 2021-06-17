package fengge.test.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfig {

    @Bean
    public MyListener getMyListener(){
        return new MyListener();
    }

    @Bean
    public MyAnnotationListener getMyAnnotationListener(){
        return new MyAnnotationListener();
    }
}
