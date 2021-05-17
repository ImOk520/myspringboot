package fengge.config.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"fengge.config.autowired"})
public class AutowiredConfig02 {

//    @Primary
    @Bean("testDAO02")
    public TestDAO testDAO(){
        TestDAO testDAO02 = new TestDAO();
        testDAO02.setLabel(2);
        return testDAO02;
    }
}
