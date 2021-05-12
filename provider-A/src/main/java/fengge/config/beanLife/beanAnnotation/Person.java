package fengge.config.beanLife.beanAnnotation;

import cn.hutool.core.lang.Console;

/**
 * Feng, Ge 2021/5/12 0012 18:08
 */
public class Person {

    public Person() {
        Console.log("构造方法！");
    }

    public void init(){
        Console.log("初始化方法！");
    }

    public void destroy(){
        Console.log("销毁方法！");
    }
}
