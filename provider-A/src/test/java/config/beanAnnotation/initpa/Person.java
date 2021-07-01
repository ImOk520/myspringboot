package config.beanAnnotation.initpa;

import cn.hutool.core.lang.Console;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Feng, Ge 2021/5/12 0012 18:08
 */
public class Person {

    public Person() {
        Console.log("Person的构造方法！");
    }

    @PostConstruct
    public void init(){
        Console.log("Person的初始化方法！");
    }

    @PreDestroy
    public void destroy(){
        Console.log("Person的销毁方法！");
    }
}
