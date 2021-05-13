package config.beanLife.componentScan;

import fengge.DTO.CarDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration // 相当于原来的xml文件，告诉spring这是个配置类
public class TestConfig {

    @Bean("car") // 给spring注入一个bean，类型是返回值类型，id是默认是方法名
    public CarDTO carDTO(){
        return new CarDTO(1,"BMW");
    }
}
