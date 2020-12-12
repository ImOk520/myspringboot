package com.feng.consumer.controller;

import com.feng.consumer.po.CarPO;
import com.feng.consumer.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Feng, Ge 2020-10-13 20:32
 */
@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisDemoController {

    @Autowired
    RedisUtil redisUtil;

    @PostMapping("/test")
    public void test() {
        CarPO carPO = new CarPO();
        carPO.setId(1);
        carPO.setBrand("66");
        redisUtil.set("car", carPO);
    }


}
