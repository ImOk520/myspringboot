package com.feng.consumer.controller;

import com.feng.client.DeptClient;
import com.feng.pojo.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Feng, Ge 2020-10-13 20:32
 */
@Slf4j
@RequestMapping("/feign")
@RestController
public class ConsumerFeignController {

    @Autowired
    private DeptClient deptClient;

    @GetMapping("/getAll")
    public List<Dept> getAllDept() {
        return deptClient.getAll();
    }

}
