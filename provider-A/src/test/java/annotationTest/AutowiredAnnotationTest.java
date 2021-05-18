package annotationTest;

import cn.hutool.core.lang.Console;
import config.componentScan.*;
import fengge.DTO.CarDTO;
import fengge.DTO.PersonDTO;
import fengge.beanPostProcessor.Config;
import fengge.config.autowired.*;
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
public class AutowiredAnnotationTest {

    /**
     *  @Autowired 注解
     *  1、可以看到该注解可以为TestService注入TestDAO
     */
    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        TestService bean = applicationContext.getBean(TestService.class);
        Console.log(bean);
    }

    /**
     *  @Autowired 注解
     *  1、如果有两个同类型bean，在getBean(注释掉的代码)时会报 expected single matching bean but found 2: testDAO,testDAO02 错误
     *  2、在有多个同类型bean时，根据注入的属性名称进行匹配，这里TestService中的TestDAO类型的属性名称是testDAO，所以注入的是label=1的bean
     */
    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        TestService bean = applicationContext.getBean(TestService.class);
        Console.log(bean);
//        TestDAO bean1 = applicationContext.getBean(TestDAO.class);
//        Console.log(bean1);
    }

    /**
     *  @Autowired 注解
     *  1、在有多个同类型bean时，根据注入的属性名称进行匹配，这里TestService中的TestDAO类型的属性名称是testDAO02，所以注入的是label=2的bean
     */
    @Test
    public void test2() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        TestService bean = applicationContext.getBean(TestService.class);
        Console.log(bean);
    }

    /**
     *  @Qualifier 注解： 在有多个同类型bean时，@Qualifier 可以指定要注入哪个bean
     *  1、这里在 TestService01 中设置了要注入 testDAO02，所以即使这里属性名称是 testDAO，注入的也是 testDAO02
     */
    @Test
    public void test3() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig01.class);
        TestService01 bean = applicationContext.getBean(TestService01.class);
        Console.log(bean);
    }

    /**
     * @Primary 注解： 在有多个同类型bean时，@Primary 可以指定要优先注入哪个bean
     *  1、这里在 AutowiredConfig02 中设置了要注入 testDAO02，则优先注入的也是 testDAO02
     */
    @Test
    public void test4() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig02.class);
        TestService01 bean = applicationContext.getBean(TestService01.class);
        Console.log(bean);
    }

    /**
     *  @Qualifier 注解： 在有多个同类型bean时，@Qualifier 可以指定要注入哪个bean
     *  1、这里在 TestService01 中设置了要注入 testDAO02，所以即使这里属性名称是 testDAO，注入的也是 testDAO02
     */
    @Test
    public void test5() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig03.class);
        TestService02 bean = applicationContext.getBean(TestService02.class);
        Console.log(bean);
    }

    /**
     *  @Resource 注解：和 @Autowired 注解 一样，只是它是JSR250提供的注解
     */
    @Test
    public void test6() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig04.class);
        TestService03 bean = applicationContext.getBean(TestService03.class);
        Console.log(bean);
    }

    /**
     *  @Inject 注解：和 @Autowired 注解 一样，只是它是JSR330提供的注解
     */
    @Test
    public void test7() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig04.class);
        TestService04 bean = applicationContext.getBean(TestService04.class);
        Console.log(bean);
    }

    /**
     *  @Autowired 注解 不仅可以注解在属性上，还可以注解在 方法、参数、构造方法上
     *  1、在哪里效果是一样的
     */
    @Test
    public void test8() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig04.class);
        TestService05 bean = applicationContext.getBean(TestService05.class);
        Console.log(bean);
    }
}
