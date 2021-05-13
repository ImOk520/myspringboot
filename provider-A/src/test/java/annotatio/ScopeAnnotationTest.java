package annotatio;

import cn.hutool.core.lang.Console;
import fengge.DTO.CarDTO;
import config.beanLife.scope.ScopeConfig_lazy;
import config.beanLife.scope.ScopeConfig_prototype;
import config.beanLife.scope.ScopeConfig_singleton;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Scope注解使用
 * Feng, Ge 2020-10-20 17:28
 */
@SpringBootTest
public class ScopeAnnotationTest {

    /**
     * @Scope 默认是singleton单例模式，这里可以看出：
     * 1、这里多次获取bean，始终返回的是同一个bean，即单例
     * 2、这里是恶汉式，IOC容器启动时就已经创建了这个单例的bean
     * 3、后面再每次获取这个bean，就是直接从容器取，类似map.get(key)
     * 4、在不同的容器中，Bean的生命周期开始的时间不同。对于ApplicationContext来说，当容器启动的时候，bean就已经实例化了。而对于BeanFactory来说，直到调用getBean()方法的时候才进行实例化。
     */
    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig_singleton.class);
        Console.log("容器创建完成");
        CarDTO bean = applicationContext.getBean(CarDTO.class);
        CarDTO bean1 = applicationContext.getBean(CarDTO.class);
        Console.log(bean);
        Console.log(bean1);
        Console.log(bean1 == bean);
    }

    /**
     * @Scope prototype原型模式，这里可以看出：
     * 1、每次获取Bean的时候会有一个新的实例
     * 2、并不是IOC容器启动时就已经创建了bean，bean是在使用时才创建
     */
    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig_prototype.class);
        Console.log("容器创建完成");
        CarDTO bean = applicationContext.getBean(CarDTO.class);
        CarDTO bean1 = applicationContext.getBean(CarDTO.class);
        Console.log(bean);
        Console.log(bean1);
        Console.log(bean1 == bean);
    }

    /**
     * 注解 @Lazy
     * 使这个bean在使用时才创建并加载到容器
     */
    @Test
    public void test3() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig_lazy.class);
        Console.log("容器创建完成");
        CarDTO bean = applicationContext.getBean(CarDTO.class);
        CarDTO bean1 = applicationContext.getBean(CarDTO.class);
        Console.log(bean);
        Console.log(bean1);
        Console.log(bean1 == bean);
    }


}
