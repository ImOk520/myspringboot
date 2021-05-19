package config.aop;

import cn.hutool.core.lang.Console;

/**
 * Feng, Ge 2021/5/19 0019 17:44
 */
public class AopOne {

    public double compute(double i, double j){
        double v = i / j;
        Console.log("商为：{}", v);
        return v;
    }
}
