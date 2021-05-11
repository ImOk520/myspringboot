package fengge.config.factoryBean;

import cn.hutool.core.lang.Console;
import fengge.DTO.CarDTO;
import fengge.DTO.PersonDTO;
import fengge.config.conditional.MyCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
public class BeanFactoryConfig {

    @Bean
    public MyFactoryBean myFactoryBean(){
        Console.log("进入BeanFactoryConfig方法");
        return new MyFactoryBean();
    }
}
