package com.feng.consumer.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * aop demo
 * Feng, Ge 2020年12月11日10:23:55
 */
@Aspect
@Component
@Slf4j
public class AspectDemo {

//    /**
//     * 切入范围时controller下面的所有public方法
//     */
//    @Pointcut("execution(public * com.feng.consumer.controller..*.*(..))")

    /**
     * AopDemoController下面的所有public方法
     */
    @Pointcut("execution(public * com.feng.consumer.controller.AopDemoController.*(..))")
    public void valid() {
    }

    /**
     * 打印参数
     *
     * @param point
     */
    @Before("valid()")
    public void controller(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Long count = Stream.of(signature.getMethod().getDeclaredAnnotations())
                .filter(annotation -> annotation.annotationType() == RequestMapping.class)
                .count();
        String requestPath = count >= 1 ? signature.getMethod().getAnnotation(RequestMapping.class).value()[0] : "";

        String info = String.format("path:%s | %s", requestPath, getMethodInfo(point));
        log.info("before:{}", info);
    }

    private String getMethodInfo(JoinPoint point) {
        String className = point.getSignature().getDeclaringType().getSimpleName();
        String methodName = point.getSignature().getName();
        String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();
        StringBuilder sb = null;
        if (Objects.nonNull(parameterNames)) {
            sb = new StringBuilder();
            for (int i = 0; i < parameterNames.length; i++) {
                String value = point.getArgs()[i] != null ? point.getArgs()[i].toString() : "null";
                sb.append(parameterNames[i] + ":" + value + "; ");
            }
        }
        sb = sb == null ? new StringBuilder() : sb;
        return String.format("class:%s | method:%s | args:%s", className, methodName, sb.toString());
    }

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     *
     * @param joinPoint joinPoint
     * @return Object
     * @throws Throwable Throwable
     */
    @Around("valid()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("method start time:" + System.currentTimeMillis());
        MyRequestWrapper request = (MyRequestWrapper) ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("【joinPoint.toString()】{}", joinPoint.toString());
        log.info("【joinPoint.getTarget()】{}", joinPoint.getTarget());
        log.info("【joinPoint.getSignature()】{}", joinPoint.getSignature());
        log.info("【joinPoint.getSignature()】{}", request.getBody());

        Object re = joinPoint.proceed();
        System.out.println("method end time:" + System.currentTimeMillis());
        return re;
    }

    //获取请求body
    public String getBodyFromRequest(HttpServletRequest request) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
        } catch (IOException e) {
            log.error("获取入参json对象出错", e);
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    log.error("获取入参json对象出错", e);
                }
            }
        }
        return br.toString();
    }

    private String readAsBytes(HttpServletRequest request) {
        int len = request.getContentLength();
        byte[] buffer = new byte[len];
        ServletInputStream in = null;
        try {
            in = request.getInputStream();
            in.read(buffer, 0, len);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (buffer.length > 0) {
            return new String(buffer);
        } else {
            return null;
        }
    }

}
