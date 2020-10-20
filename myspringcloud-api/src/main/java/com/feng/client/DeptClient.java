package com.feng.client;

import com.feng.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Feng, Ge 2020-10-20 14:16
 */
@Component
@FeignClient(value = "provider")
public interface DeptClient {

    @PostMapping("/dept/add")
    boolean add(@RequestBody Dept dept);

    @GetMapping("/dept/getById/{deptno}")
    Dept getById(@PathVariable("deptno") Long deptno);

    @GetMapping("/dept/getAll")
    List<Dept> getAll();

}
