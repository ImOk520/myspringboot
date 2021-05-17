package config.factoryBean;

import cn.hutool.core.lang.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanFactoryConfig {

    @Bean
    public MyFactoryBean myFactoryBean(){
        Console.log("进入BeanFactoryConfig方法");
        return new MyFactoryBean();
    }
}
