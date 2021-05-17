package annotationTest;

import cn.hutool.core.lang.Console;
import fengge.config.value.Config01;
import fengge.config.value.Person;
import fengge.config.value.Person01;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Feng, Ge 2021/5/17 0017 9:03
 */
@SpringBootTest
public class ValueTest {


    /**
     * 未使用@Value注解时，这里的bean的属性值都是空
     */
    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config01.class);
        Person person = applicationContext.getBean(Person.class);
        Console.log(person);
    }

    /**
     * 使用@Value注解时，这里的bean的属性值已经绑定相应的值
     */
    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config01.class);
        Person01 person01 = applicationContext.getBean(Person01.class);
        Console.log(person01);
        String property = applicationContext.getEnvironment().getProperty("person.sex");
        Console.log(property);
    }
}
