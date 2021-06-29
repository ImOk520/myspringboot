package PopulateBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("G:\\myspringcloud\\provider-A\\src\\test\\java\\PopulateBean\\config.xml");
        TestBean testBean = context.getBean("testBean", TestBean.class);
        testBean.echo();
    }
}
