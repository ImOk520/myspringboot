package fengge.config.scope;

import cn.hutool.core.lang.Console;
import fengge.DTO.CarDTO;
import fengge.DTO.PersonDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 注解 @Scope
 *  a.singleton单例模式 -- 全局有且仅有一个实例 （默认）
 *  b.prototype原型模式 -- 每次获取Bean的时候会有一个新的实例
 *  c.request -- request表示该针对每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP request内有效
 *  d.session -- session作用域表示该针对每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP session内有效
 *  e.globalsession -- global session作用域类似于标准的HTTP Session作用域，不过它仅仅在基于portlet的web应用中才有意义
 */
@Configuration
@ComponentScan(value = "fengge.dao")
public class ScopeConfig_singleton {

    @Scope
    @Bean
    public CarDTO carDTO(){
        Console.log("carDTO创建，并添加到容器");
        return new CarDTO(1,"BMW");
    }

}
