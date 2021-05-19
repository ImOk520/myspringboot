package config.aop;

import org.springframework.context.annotation.Bean;
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
    public AopOneAspect oneAspect() {
        return new AopOneAspect();
    }
}
