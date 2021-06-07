package config.ignore;

import config.ignore.Admin;
import config.ignore.Config;
import config.ignore.Person;
import config.ignore.User;
import config.ignore.UserAware;
import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Feng, Ge 2021/6/7 0007 10:09
 */
@SpringBootTest
public class IgnoreTest {

    @Test
    public void testIgnore(){
        ClassPathResource classPathResource = new ClassPathResource("beanFactoryTest.xml");
        XmlBeanFactory beanFactory=new XmlBeanFactory(classPathResource);
        //beanFactory.ignoreDependencyInterface(UserAware.class);//测试ignoreDependencyInterface方法作用
        //beanFactory.ignoreDependencyType(Admin.class);//测试ignoreDependencyType方法作用
        Person person = beanFactory.getBean(Person.class);
        System.out.println(person);
    }
}
