package config.beanAnnotation.initpa;

import cn.hutool.core.lang.Console;
import config.aop.AopOne;
import config.aop.AopOneConfig;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class AopOneTestr {

    @Test
    public void test4() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanLifeConfig04.class);
        Console.log("容器创建完成！");
        applicationContext.close();
    }
}
