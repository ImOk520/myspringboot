package com.feng.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Feng, Ge 2020-10-13 20:32
 */
@Slf4j
@RequestMapping("/hystrix")
@RestController
@DefaultProperties(defaultFallback = "defaultBack")
public class HystrixDemoController {

    @HystrixCommand(fallbackMethod = "friendlyBack_1")
    @GetMapping("/demo1")
    public String demo1() {
        throw new RuntimeException();
    }

    private String friendlyBack_1() {
        return "返回友好界面——1";
    }

    @HystrixCommand(fallbackMethod = "friendlyBack_2")
    @GetMapping("/demo2")
    public String demo2() {
        System.out.println("进入demo2....");
        throw new RuntimeException();
    }

    @HystrixCommand(defaultFallback = "friendlyBack_3")
    private String friendlyBack_2() {
        System.out.println("进入friendlyBack_2....");
        throw new RuntimeException();
    }

    @HystrixCommand
    private String friendlyBack_3() {
        System.out.println("进入friendlyBack_3....");
        throw new RuntimeException();
    }

    private String defaultBack() {
        System.out.println("进入defaultBack....");
        return "默认友好界面";
    }


    @HystrixCommand(commandProperties =
            {
                // 熔断器在整个统计时间内是否开启的阀值
                @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                // 至少有3个请求才进行熔断错误比率计算
                /**
                 * 设置在一个滚动窗口中，打开断路器的最少请求数。
                 比如：如果值是20，在一个窗口内（比如10秒），收到19个请求，即使这19个请求都失败了，断路器也不会打开。
                 */
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
                //当出错率超过50%后熔断器启动
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                // 熔断器工作时间，超过这个时间，先放一个请求进去，成功的话就关闭熔断，失败就再等一段时间
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
                // 统计滚动的时间窗口
                @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
            })
    @GetMapping("/demo3")
    public String demo3(Integer id) {
        System.out.println("id:" + id);
        if (id % 2 == 0) {
            throw new RuntimeException();
        }
        return "test_" + id;
    }

}
