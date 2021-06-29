package fengge.test.PopulateBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        TestBean testBean = context.getBean("testBean", TestBean.class);
        testBean.echo();
    }
}
