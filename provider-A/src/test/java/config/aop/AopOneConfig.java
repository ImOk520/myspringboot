package config.aop;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class AopOneConfig {

    @Bean
    public AopOne aopOne() {
        return new AopOne();
    }

    @Bean
    @ConditionalOnBean(name = "aopOne") // 如果aopOne存在才实例化AopOneAspect
    public AopOneAspect oneAspect() {
        return new AopOneAspect();
    }
}
