package fengge.controller;

import cn.hutool.core.lang.Console;
import fengge.DTO.CarDTO;
import fengge.ProviderA;
import fengge.config.conditional.ConditionalTestConfig02;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;


/**
 * Feng, Ge 2020-10-08 21:57
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
    public void test() {
        Map<String, CarDTO> beans = context.getBeansOfType(CarDTO.class);
        Console.log(beans);
    }
}
