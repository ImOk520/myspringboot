package config.beanLife.interfaceInit;

import cn.hutool.core.lang.Console;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Feng, Ge 2021/5/12 0012 18:08
 */
public class Person implements InitializingBean, DisposableBean {

    public Person() {
        Console.log("构造方法！");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Console.log("初始化方法！");
    }

    @Override
    public void destroy(){
        Console.log("销毁方法！");
    }


}
