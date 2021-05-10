package annotationTest;

import cn.hutool.core.lang.Console;
import fengge.DTO.CarDTO;
import fengge.config.importAnnotation.ImportTestConfig;
import fengge.config.importAnnotation.ImportTestConfig01;
import fengge.config.scope.ScopeConfig_lazy;
import fengge.config.scope.ScopeConfig_prototype;
import fengge.config.scope.ScopeConfig_singleton;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @Import 注解使用
 * Feng, Ge 2020-10-20 17:28
 */
@SpringBootTest
public class ImportAnnotationTest {

    /**
     * @Import
     * 未使用@Import时，A\B两个bean不会注册到容器
     */
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportTestConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

    /**
     * @Import
     * 使用@Import导入A、B后，两个bean不会注册到容器
     */
    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportTestConfig01.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

    /**
     * 注解 @Lazy
     * 使这个bean在使用时才创建并加载到容器
     */
    @Test
    public void test3() {

    }


}
