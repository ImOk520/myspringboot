package annotationTest;

import cn.hutool.core.lang.Console;
import config.componentScan.TestConfig06;
import fengge.config.autowired.AutowiredConfig;
import fengge.config.autowired.AutowiredConfig01;
import fengge.config.autowired.AutowiredConfig02;
import fengge.config.autowired.AutowiredConfig03;
import fengge.config.autowired.AutowiredConfig04;
import fengge.config.autowired.TestService;
import fengge.config.autowired.TestService01;
import fengge.config.autowired.TestService02;
import fengge.config.autowired.TestService03;
import fengge.config.autowired.TestService04;
import fengge.config.autowired.TestService05;
//import fengge.config.profile.ProfileConfig;
import fengge.config.profile.ProfileConfig01;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * spring 注解测试类
 * Feng, Ge 2020-10-20 17:28
 */
@SpringBootTest
public class ProfileAnnotationTest {

    /**
     *  @Autowired 注解
     *  1、可以看到该注解可以为TestService注入TestDAO
     */
    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProfileConfig01.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

}
