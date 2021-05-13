package config.beanLife.scope;

import cn.hutool.core.lang.Console;
import fengge.DTO.CarDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 *  注解 @Lazy
 *  我们知道@Scope的类型是singleton单例模式，是在IOC容器启动时就已经创建了这个单例的bean
 *  若要使这个bean在使用时才创建并加载到容器，就可以使用 @Lazy 注解
 */
@Configuration
@ComponentScan(value = "fengge.dao")
public class ScopeConfig_lazy {

    @Scope
    @Lazy
    @Bean
    public CarDTO carDTO(){
        Console.log("carDTO创建，并添加到容器");
        return new CarDTO(1,"BMW");
    }

}
