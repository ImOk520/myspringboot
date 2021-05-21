package config.aop;

import cn.hutool.core.lang.Console;
import fengge.config.importAnnotation.E;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.stream.Stream;

/**
 * Feng, Ge 2021/5/19 0019 17:48
 */
@Aspect
public class AopOneAspect {

    @Pointcut("execution(public * config.aop.AopOne.*(..))")
    public void pointCut(){
    };

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        Console.log("@Before:方法前执行.....");
        Console.log("【0】切点的签名信息{}", joinPoint.getSignature());
        Console.log("【1】目标类{}", joinPoint.getSignature().getDeclaringType());
        Console.log("【2】切点方法名称{}", joinPoint.getSignature().getName());
        Console.log("【3】目标类全类名{}", joinPoint.getSignature().getDeclaringTypeName());
        Console.log("【4】切点方法的权限映射的int类型{}", joinPoint.getSignature().getModifiers());
        Console.log("【5】切点的签名信息{}", joinPoint.getSignature().toString());
        Console.log("【6】切点的签名完整信息{}", joinPoint.getSignature().toLongString());
        Console.log("【7】切点的简略签名信息{}", joinPoint.getSignature().toShortString());
        Console.print("【8】切点参数");
        Object[] args = joinPoint.getArgs();
        Stream.of(args).forEach(System.out::println);
        Console.log("【9】切点类型{}", joinPoint.getKind());
        Console.log("【10】切点点方法所在类文件中的位置{}", joinPoint.getSourceLocation());
        Console.log("【11】切点静态部分 {}", joinPoint.getStaticPart());
        Console.log("【12】目标类对象{}", joinPoint.getTarget());
        Console.log("【13】目标类对象{}", joinPoint.getThis());
        Console.log("【14】切点所在位置的相关信息{}", joinPoint.toString());
        Console.log("【15】切点所在位置的相关完整信息{}", joinPoint.toLongString());
        Console.log("【16】切点所在位置的相关简略信息{}", joinPoint.toShortString());
    }

    @After("pointCut()")
    public void after(){
        Console.log("@After:无论是否异常，都会在方法后执行.....");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        Console.log("@AfterReturning:只有方法正常执行后，才会执行.....");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        Console.log("@AfterThrowing:只有方法出现异常后，才会执行.....异常为：" + exception);
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Console.log("@Around:会在方法前后都执行(1).....");
        Object obj = null;
        obj = joinPoint.proceed();
        Object[] args = {12, 2};
//        joinPoint.proceed(args);
        Console.log("@Around 会在方法前后都执行(2).....");
        return obj;
    }
}
