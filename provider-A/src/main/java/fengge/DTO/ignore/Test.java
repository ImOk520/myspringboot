package fengge.DTO.ignore;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Feng, Ge 2021/6/7 0007 13:41
 */
public class Test {
    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("beanFactoryTest.xml");
        XmlBeanFactory beanFactory=new XmlBeanFactory(classPathResource);
        beanFactory.ignoreDependencyInterface(UserAware.class);
        beanFactory.ignoreDependencyType(Admin.class);//测试ignoreDependencyType方法作用
        Person person = beanFactory.getBean(Person.class);
        System.out.println(person);
    }
}
