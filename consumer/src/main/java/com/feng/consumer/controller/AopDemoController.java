package com.feng.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.feng.consumer.DTO.CarDTO;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * Feng, Ge 2020-10-13 20:32
 */
@Slf4j
@RequestMapping("/aop")
@RestController
public class AopDemoController {

    @PostMapping("/test")
    public void sendMedicalVisitInnfoStandard(@Valid @RequestBody CarDTO carDTO) {
        log.info("【主方法：】{}", JSONObject.toJSONString(carDTO));
    }


}
