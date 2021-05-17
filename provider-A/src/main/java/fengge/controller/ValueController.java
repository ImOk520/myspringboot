package fengge.controller;

import cn.hutool.core.lang.Console;
import fengge.config.value.Person;
import fengge.config.value.Person01;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.stream.Stream;


/**
 *
 */
@RestController
@RequestMapping("/value")
public class ValueController implements ApplicationContextAware {

    private WebApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = (WebApplicationContext) applicationContext;
    }

    /**
     * 未使用@Value注解时，这里的bean的属性值都是空
     */
    @GetMapping("/test")
    public Person test() {
        Person person = context.getBean(Person.class);
        Console.log(person);
        return person;
    }

    /**
     * 使用@Value注解时，这里的bean的属性值已经绑定相应的值
     */
    @GetMapping("/test1")
    public Person01 test1() {
        String property = context.getEnvironment().getProperty("person.sex");
        Console.log("重环境对象中获取的配置信息：" + property);
        Person01 person = context.getBean(Person01.class);
        Console.log(person);
        return person;
    }
}
