package fengge.config.self;

import cn.hutool.core.lang.Console;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

/**
 * 想把spring容器中的一些底层组件注入自定义的bean，就需要实现对应的xxxAware接口
 */
public class Ship implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    private ApplicationContext applicationContext;
    private String name;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        Console.log("[0]" + applicationContext);
    }

    @Override
    public void setBeanName(String s) {
        this.name = s;
        Console.log("[1]" + s);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("哈哈哈${person.sex}#{90-10}");
        Console.log("[2]" + resolver);
        Console.log("[3]" + s);
    }
}
