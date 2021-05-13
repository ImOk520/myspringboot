package fengge;

import cn.hutool.core.lang.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

import java.util.stream.Stream;

/**
 * Feng, Ge 2020-10-08 22:05
 */
//@EnableEurekaClient
@SpringBootApplication
public class ProviderA {
    private static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(ProviderA.class, args);
        Console.log(applicationContext.getBean("carDTO"));
        displayAllBeans();
    }

    public static void displayAllBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        Stream.of(allBeanNames).forEach(System.out::println);
    }
}
