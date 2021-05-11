package fengge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

/**
 * Feng, Ge 2020-10-08 22:05
 */
@EnableEurekaClient
@SpringBootApplication
public class ProviderA {
    private static ApplicationContext applicationContext;
    public static void main(String[] args) {
        SpringApplication.run(ProviderA.class, args);
        displayAllBeans();
    }

    public static void displayAllBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }
}
