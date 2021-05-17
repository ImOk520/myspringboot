package fengge.config.autowired;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"fengge.config.autowired"})
public class AutowiredConfig03 {

    public TestDAO testDAO(){
        TestDAO testDAO02 = new TestDAO();
        testDAO02.setLabel(2);
        return testDAO02;
    }
}
