package annotationTest;

import cn.hutool.core.lang.Console;
import config.beanLife.factoryBean.BeanFactoryConfig;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * FactoryBean
 * Feng, Ge 2020-10-20 17:28
 */
@SpringBootTest
public class FactoryBeanTest {

    /**
     *
     */
    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanFactoryConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

    /**
     * 1、这里getBean("myFactoryBean")，是小写的，@Bean注解没有指定value时，默认方法名为id
     * 2、@Bean注解是加在返回类型为MyFactoryBean类型的方法上的，但是getBean("myFactoryBean")时返回的bean并不是MyFactoryBean类型的组件，
     *    实际返回的是它里面的getObject()方法产生的CarDTO类型的bean
     * 3、因为MyFactoryBean中的isSingleton（）方法返回值为true，即单例模式，容器中只有一份实例，多次获取的是同一实例
     */
    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanFactoryConfig.class);
        Console.log("容器已创建完成！");
        Object myFactoryBean = applicationContext.getBean("myFactoryBean");
        Console.log("实际生成的bean：" + myFactoryBean);
        Object myFactoryBean01 = applicationContext.getBean("myFactoryBean");
        Console.log("实际生成的bean：" + myFactoryBean01);
        Console.log(myFactoryBean == myFactoryBean01);
    }

    /**
     * 因为MyFactoryBean中的isSingleton（）方法返回值为false，即多例模式，每次获取的是不同实例
     */
    @Test
    public void test2() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanFactoryConfig.class);
        Console.log("容器已创建完成！");
        Object myFactoryBean = applicationContext.getBean("myFactoryBean");
        Console.log("实际生成的bean：" + myFactoryBean);
        Object myFactoryBean01 = applicationContext.getBean("myFactoryBean");
        Console.log("实际生成的bean：" + myFactoryBean01);
        Console.log(myFactoryBean == myFactoryBean01);
    }


}
