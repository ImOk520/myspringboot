package annotationTest;

import cn.hutool.core.lang.Console;
import fengge.DTO.CarDTO;
import fengge.config.conditional.ConditionalTestConfig;
import fengge.config.conditional.ConditionalTestConfig01;
import fengge.config.conditional.ConditionalTestConfig02;
import fengge.config.scope.ScopeConfig_lazy;
import fengge.config.scope.ScopeConfig_prototype;
import fengge.config.scope.ScopeConfig_singleton;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @Conditional 注解使用
 * Feng, Ge 2020-10-20 17:28
 */
@SpringBootTest
public class ConditionalAnnotationTest {

    /**
     * @Conditional 给bean增加条件，满足条件后这个bean才能注册进容器：
     * 1、这里并未给CarDTO类型的bean使用@Conditional注解，所以两个bean都注入容器了
     */
    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalTestConfig.class);
        Console.log("容器创建完成");
        Map<String, CarDTO> beans = applicationContext.getBeansOfType(CarDTO.class);
        Object ppp = applicationContext.getBean("ppp");
        Console.log(beans);
        Console.log(ppp);
    }

    /**
     * @Conditional
     * 1、matches(ConditionContext context, AnnotatedTypeMetadata metadata)
 *      AnnotatedTypeMetadata: 注解所在位置的注释信息
 *      ConditionContext: 判断条件能使用的上下文环境
     */
    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalTestConfig01.class);
        Map<String, CarDTO> beans = applicationContext.getBeansOfType(CarDTO.class);
        Console.log(beans);
    }

    @Test
    public void test3() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalTestConfig02.class);
        Map<String, CarDTO> beans = applicationContext.getBeansOfType(CarDTO.class);
        Console.log(beans);
    }


}
