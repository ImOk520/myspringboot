package annotatio;

import cn.hutool.core.lang.Console;
import fengge.DTO.CarDTO;
import fengge.config.importAnnotation.ImportTestConfig;
import fengge.config.importAnnotation.ImportTestConfig01;
import fengge.config.importAnnotation.ImportTestConfig02;
import fengge.config.importAnnotation.ImportTestConfig03;
import fengge.config.scope.ScopeConfig_lazy;
import fengge.config.scope.ScopeConfig_prototype;
import fengge.config.scope.ScopeConfig_singleton;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @Scope注解使用
 * Feng, Ge 2020-10-20 17:28
 */
@SpringBootTest
public class ImportAnnotationTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportTestConfig02.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
