package annotationTest;

import cn.hutool.core.lang.Console;
import config.componentScan.TestConfig;
import config.value.Config;
import config.value.Person;
import fengge.DTO.CarDTO;
import fengge.DTO.PersonDTO;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Feng, Ge 2021/5/17 0017 9:03
 */
@SpringBootTest
public class ValueTest {


    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        Person person = applicationContext.getBean(Person.class);
        Console.log(person);
    }
}
