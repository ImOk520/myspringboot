package config.aop;

import cn.hutool.core.lang.Console;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Feng, Ge 2021/5/19 0019 17:48
 */
@Aspect
public class AopOneAspect {

    @Pointcut("execution(public double config.aop.AopOne.compute())")
    public void pointCut(){
    };

    @Before("pointCut()")
    public void before(){
        Console.log("方法前执行.....");
    }

    @After("pointCut()")
    public void after(){
        Console.log("无论是否异常，都会在方法后执行.....");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        Console.log("只有方法正常执行后，才会执行.....");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        Console.log("只有方法出现异常后，才会执行.....");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        Console.log("只有方法出现异常后，才会执行.....");
    }
}
