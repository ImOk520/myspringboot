package config.beanLife.applicationContext;

import cn.hutool.core.lang.Console;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PreDestroy;
import java.util.stream.Stream;


public class Person implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Person() {
        Console.log("Person构造方法！");
    }

    @PreDestroy
    public void destroy(){
        Console.log("Person销毁方法！");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        Console.log("容器唯一ID：" + applicationContext.getId());
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
