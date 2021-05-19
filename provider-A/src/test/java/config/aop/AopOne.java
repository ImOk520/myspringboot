package config.aop;

import cn.hutool.core.lang.Console;

/**
 * Feng, Ge 2021/5/19 0019 17:44
 */
public class AopOne {

    public void compute(int i, int j){
        int v = i / j;
        Console.log("目标类方法执行，商为：{}", v);
    }
}
