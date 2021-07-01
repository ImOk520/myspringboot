package config.aop;

import config.beanAnnotation.Person;
import fengge.config.importAnnotation.A;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.*;

@EnableAspectJAutoProxy
@Configuration
public class AopOneConfig {

    @Bean
    public AopOne aopOne() {
        return new AopOne();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Person person() {
        return new Person();
    }

    @Bean
//    @ConditionalOnBean(name = "aopOne") // 如果aopOne存在才实例化AopOneAspect
    public AopOneAspect aopOneAspect() {
        return new AopOneAspect();
    }
}


//package config.aop;
//
//import fengge.config.importAnnotation.A;
//import fengge.config.importAnnotation.B;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.context.annotation.*;
//import org.springframework.stereotype.Component;
//
//@EnableAspectJAutoProxy
//@Configuration
//@PropertySource(value = "classpath:user.properties", encoding = "UTF-8")
//@ComponentScan(value = "fengge.dao")
//@ImportResource("classpath:demo.xml")
//@Import({A.class, B.class})
//public class AopOneConfig implements DemoInterface{
//
//    @Bean
//    public AopOne aopOne() {
//        return new AopOne();
//    }
//
//    @Bean
//    @ConditionalOnBean(name = "aopOne") // 如果aopOne存在才实例化AopOneAspect
//    public AopOneAspect oneAspect() {
//        return new AopOneAspect();
//    }

//    @Override
//    public String selectData() {
//        return "ok";
//    }
//
//    @Component
//    class InnerClass{
//
//    }
//}

