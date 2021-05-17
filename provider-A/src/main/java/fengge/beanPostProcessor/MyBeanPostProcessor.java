package fengge.beanPostProcessor;

import cn.hutool.core.lang.Console;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Feng, Ge 2021/5/14 0014 17:15
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Console.log("postProcessBeforeInitialization 在初始化方法前执行" + beanName + "###" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Console.log("postProcessAfterInitialization 在初始化方法后执行" + beanName + "###" + bean);
        return bean;
    }
}
