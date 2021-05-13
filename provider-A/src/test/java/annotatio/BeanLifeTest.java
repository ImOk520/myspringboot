package annotatio;

import cn.hutool.core.lang.Console;
import config.beanLife.beanAnnotation.BeanLifeConfig;
import config.beanLife.beanAnnotation.BeanLifeConfig01;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring 注解测试类
 * Feng, Ge 2020-10-20 17:28
 */
@SpringBootTest
public class BeanLifeTest {

    /**
     * 1.可以通过 @Bean(initMethod = "init", destroyMethod = "destroy") 来指定一个bean的初始化及销毁方法
     * 2.可以在指定的初始化及销毁方法中完成我们想要的逻辑
     * 3.这里创建的bean是单实例的，在容器启动时就已经创建并初始化
     */
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanLifeConfig.class);
        Console.log("容器创建完成！");
        applicationContext.close();
    }

    /**
     * 1.这里创建的bean是多实例的，在获取的时候才会创建并初始化
     * 2.容器销毁时也没有调用销毁方法
     * 3.当用户getBean获得prototype bean的实例后，IOC容器就不再对当前实例进行管理，而是把管理权交由用户，此后再getBean生成的是新的实例。
     */
    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanLifeConfig01.class);
        Console.log("容器创建完成！");
        Object getPerson = applicationContext.getBean("getPerson");
        applicationContext.close();
    }

    /**
     * 扫描路径 @ComponentScan(value = "fengge.controller")
     */
    @Test
    public void test2() {

    }

    /**
     * 扫描路径 @ComponentScan(value = "fengge.dao")
     * 这个路径下有一个是接口类型DeptDao，不是具体的类，所以不会产生bean，控制台会打印 Ignored because not a concrete top-level 信息
     * 同时可以看到，@Bean、@Controller、@Service、@Component、@Repository注解的类都会被扫描成bean，注册到容器
     */
    @Test
    public void test3() {

    }

    /**
     * excludeFilters排除某些范围
     * 这里按注解类型排除了@Controller、@Service注解的bean
     */
    @Test
    public void test4() {

    }

    /**
     * includeFilters指定某些范围
     * 这里按注解类型排除了@Controller、@Service注解的bean
     * useDefaultFilters默认是true。表示使用默认的过滤器。即默认Filter就会处理@Component、@Controller、@Service、@Repository这些注解的Bean。
     * 所以不把useDefaultFilters = false，则不仅fengge.dao下的@Controller、@Service会扫描到，@Component、@Repository也会被扫描到
     */
    @Test
    public void test5() {

    }


}
