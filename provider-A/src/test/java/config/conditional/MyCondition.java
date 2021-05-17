package config.conditional;

import cn.hutool.core.lang.Console;
import fengge.DTO.CarDTO;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 实现Condition是个接口中的matches方法，返回true则注入bean，false则不注入。
 */
public class MyCondition implements Condition {

    /**
     * AnnotatedTypeMetadata:注解所在位置的注释信息
     * ConditionContext:判断条件能使用的上下文环境
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        Console.log("【1】" + beanFactory);
        //获取类加载器
        ClassLoader classLoader = context.getClassLoader();
//        Console.log("【2】" + classLoader);
        //获取当前环境信息
        Environment environment = context.getEnvironment();
//        Console.log("【3】" + environment);
        //获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
//        Console.log("【4】" + registry);
        Class<? extends AnnotatedTypeMetadata> aClass = metadata.getClass();
        Console.log("【5】" + aClass);
        String[] beanNamesForType = context.getBeanFactory().getBeanNamesForType(CarDTO.class);
        Console.log("【6】" + context.getEnvironment().getProperty("server.port"));
        return true;
    }
}
