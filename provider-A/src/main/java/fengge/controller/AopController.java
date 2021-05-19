//package fengge.controller;
//
//import cn.hutool.core.lang.Console;
//import fengge.config.aop.AopOne;
//import fengge.config.self.Ship;
//import fengge.config.value.Person01;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.stream.Stream;
//
//
///**
// *
// */
//@RestController
//@RequestMapping("/aop")
//public class AopController implements ApplicationContextAware {
//
//    private WebApplicationContext context;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        context = (WebApplicationContext) applicationContext;
//    }
//
//    @GetMapping("/test")
//    public void test() {
//        AopOne bean = context.getBean(AopOne.class);
//        bean.compute(10, 1);
//    }
//
//}
