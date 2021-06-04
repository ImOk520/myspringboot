package thread;

import cn.hutool.core.lang.Console;
import config.aop.AopOne;
import config.aop.AopOneConfig;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class AopOneTest {

    @Test
    public void test() {
        AopOne aopOne = new AopOne();
        aopOne.compute(10, 1);
    }

    @Test
    public void test1() {
        AopOne aopOne = new AopOne();
        aopOne.compute(10, 1);
        Console.log("=====================================================================");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopOneConfig.class);
        AopOne bean = applicationContext.getBean(AopOne.class);
        bean.compute(10, 1);
    }
}
