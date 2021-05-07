import cn.hutool.core.lang.Console;
import fengge.DTO.CarDTO;
import fengge.DTO.PersonDTO;
import fengge.config.componentScan.TestConfig;
import fengge.config.componentScan.TestConfig01;
import fengge.config.componentScan.TestConfig02;
import fengge.config.componentScan.TestConfig03;
import fengge.config.componentScan.TestConfig04;
import fengge.config.componentScan.TestConfig05;
import fengge.config.componentScan.TestConfig06;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.util.stream.Stream;

/**
 * spring 注解测试类
 * Feng, Ge 2020-10-20 17:28
 */
@SpringBootTest
public class AnnotationTest {

    /**
     * 注解 @Configuration 和 @Bean
     */
    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        CarDTO bean = applicationContext.getBean(CarDTO.class);
        Console.log(bean);
        PersonDTO bean1 = applicationContext.getBean(PersonDTO.class);
        Console.log(bean1);
    }

    /**
     * applicationContext.getBeanDefinitionNames() 获取容器中所有bean的name，
     * 通过这个可以判断@ComponentScan（）扫描配置是否正确
     */
    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        Console.log(applicationContext.getBeanDefinitionNames());
    }

    /**
     * 扫描路径 @ComponentScan(value = "fengge.controller")
     */
    @Test
    public void test2() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

    /**
     * 扫描路径 @ComponentScan(value = "fengge.dao")
     * 这个路径下有一个是接口类型DeptDao，不是具体的类，所以不会产生bean，控制台会打印 Ignored because not a concrete top-level 信息
     * 同时可以看到，@Bean、@Controller、@Service、@Component、@Repository注解的类都会被扫描成bean，注册到容器
     */
    @Test
    public void test3() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig01.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

    /**
     * excludeFilters排除某些范围
     * 这里按注解类型排除了@Controller、@Service注解的bean
     */
    @Test
    public void test4() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig02.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

    /**
     * includeFilters指定某些范围
     * 这里按注解类型排除了@Controller、@Service注解的bean
     * useDefaultFilters默认是true。表示使用默认的过滤器。即默认Filter就会处理@Component、@Controller、@Service、@Repository这些注解的Bean。
     * 所以不把useDefaultFilters = false，则不仅fengge.dao下的@Controller、@Service会扫描到，@Component、@Repository也会被扫描到
     */
    @Test
    public void test5() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig03.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

    /**
     * includeFilters指定某些范围
     * FilterType.ASSIGNABLE_TYPE是扫描指定类型，即DeptDaoClass_Component类型
     */
    @Test
    public void test6() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig04.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

    /**
     * includeFilters指定某些范围
     * FilterType.CUSTOM是自定义扫描类型，即className包含“Co”类型
     */
    @Test
    public void test7() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig05.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

    /**
     *  注解@ComponentScans可包含多个@ComponentScan，扫描范围取并集
     */
    @Test
    public void test8() throws ParseException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig06.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

    @Test
    public void test9() {

    }

}
