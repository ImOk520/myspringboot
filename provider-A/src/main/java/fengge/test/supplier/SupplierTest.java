package fengge.test.supplier;

import fengge.test.user.Address;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * 通过BeanDefinition的Supplier来实例化bean
 * Feng, Ge 2021/6/23 0023 16:16
 */
public class SupplierTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(Address.class);
        beanDefinition.setInstanceSupplier(SupplierTest::getAddress);
        applicationContext.registerBeanDefinition(Address.class.getSimpleName(), beanDefinition);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean(Address.class).toString());
    }

    private static Address getAddress() {
        return new Address("18888888", "地球");
    }
}
