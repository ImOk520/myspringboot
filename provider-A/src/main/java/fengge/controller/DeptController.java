package fengge.controller;

import cn.hutool.core.lang.Console;
import fengge.DTO.PersonDTO;
import fengge.config.self.Ship;
import fengge.config.value.Person01;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.stream.Stream;


/**
 *
 */
@RestController
@RequestMapping("/dept")
public class DeptController implements ApplicationContextAware {

    private WebApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = (WebApplicationContext) applicationContext;
    }

    @GetMapping("/test")
    public String[] test() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Console.log(context.getBean("carDTO"));
        Console.log(context.getApplicationName());
        Stream.of(beanDefinitionNames).forEach(System.out::println);
        return beanDefinitionNames;
    }

    @GetMapping("/test1")
    public Person01 test1() {
        Person01 person = context.getBean(Person01.class);
        Console.log(person);
        return person;
    }

    @GetMapping("/test2")
    public Ship test2() {
        Ship bean = context.getBean(Ship.class);
        Console.log(bean);
        return bean;
    }

    @GetMapping("/test3")
    public void test3() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

    @PostMapping("/test4")
    public PersonDTO test4(@RequestBody PersonDTO personDTO) {
        return personDTO;
    }
}
