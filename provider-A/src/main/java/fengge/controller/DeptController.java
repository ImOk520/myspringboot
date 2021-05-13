package fengge.controller;

import cn.hutool.core.lang.Console;
import fengge.DTO.CarDTO;
import fengge.config.importAnnotation.A;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;
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
}
