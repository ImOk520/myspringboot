package config.aop;

import cn.hutool.core.lang.Console;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Feng, Ge 2021/5/19 0019 17:48
 */
@Aspect
public class AopOneAspect {

    @Pointcut("execution(public * config.aop.AopOne.*(..))")
    public void pointCut(){
    };

    @Before("pointCut()")
    public void before(){
        Console.log("@Before:方法前执行.....");
    }

    @After("pointCut()")
    public void after(){
        Console.log("@After:无论是否异常，都会在方法后执行.....");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        Console.log("@AfterReturning:只有方法正常执行后，才会执行.....");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        Console.log("@AfterThrowing:只有方法出现异常后，才会执行.....");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Console.log("@Around:会在方法前后都执行(1).....");
        Object obj = null;
        obj = joinPoint.proceed();
        Console.log("@Around 会在方法前后都执行(2).....");
        return obj;
    }
}
