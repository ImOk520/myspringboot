package com.feng.consumer.controller;

import com.feng.pojo.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * Feng, Ge 2020-10-13 20:32
 */
@Slf4j
@RequestMapping("/rest-template")
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getForEntityList")
    public List<Dept> getAllDept() {
        String url = "http://provider/dept/getAll";
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
        log.info("headers:{}", responseEntity.getHeaders());
        log.info("statusCode:{}", responseEntity.getStatusCode());
        log.info("statusCodeValue1:{}", responseEntity.getStatusCodeValue());
        log.info("statusCodeValue2:{}", responseEntity.getStatusCode().value());
        List<Dept> list = responseEntity.getBody();
        log.info("list:{}", list);
        return list;
    }

    @GetMapping("/getForObjectList")
    public List<Dept> getForObjectList() {
        String url = "http://localhost:8001/dept/getAll";
        List<Dept> forObject = restTemplate.getForObject(url, List.class);
        log.info("list:{}", forObject);
        return forObject;
    }

    @GetMapping("/getForEntity/{id}")
    public Dept getDeptById(@PathVariable("id") Long id) {
        String url = "http://localhost:8001/dept/getById/{deptno}";
        ResponseEntity<Dept> responseEntity = restTemplate.getForEntity(url, Dept.class, id);
        log.info("headers:{}", responseEntity.getHeaders());
        log.info("statusCode:{}", responseEntity.getStatusCode());
        log.info("statusCodeValue1:{}", responseEntity.getStatusCodeValue());
        log.info("statusCodeValue2:{}", responseEntity.getStatusCode().value());
        Dept dept = responseEntity.getBody();
        log.info("dept:{}", dept);
        return dept;
    }

    @GetMapping("/getForObject/{id}")
    public Dept getForObject(@PathVariable("id") Long id) {
        String url = "http://localhost:8001/dept/getById/{deptno}";
        Dept dept = restTemplate.getForObject(url, Dept.class, id);
        log.info("dept:{}", dept);
        return dept;
    }

    @GetMapping("/getForEntityWithMap/{id}")
    public Dept getForEntityWithMap(@PathVariable("id") Long id) {
        String url = "http://localhost:8001/dept/getById/{deptno}";
        HashMap<String, Long> map = new HashMap();
        map.put("deptno", id);
        ResponseEntity<Dept> responseEntity = restTemplate.getForEntity(url, Dept.class, map);
        Dept dept = responseEntity.getBody();
        log.info("dept:{}", dept);
        return dept;
    }

    @GetMapping("/getForObjectWithMap/{id}")
    public Dept getForObjectWithMap(@PathVariable("id") Long id) {
        String url = "http://localhost:8001/dept/getById/{deptno}";
        HashMap<String, Long> map = new HashMap();
        map.put("deptno", id);
        Dept dept = restTemplate.getForObject(url, Dept.class, map);
        log.info("dept:{}", dept);
        return dept;
    }

    @PostMapping("/save-dept")
    public String saveDept(Dept dept) {
        String url = "http://localhost:8001/dept/add";
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, dept, String.class);
        log.info("stringResponseEntity:{}", stringResponseEntity);
        return stringResponseEntity.getBody();
    }

    @PostMapping("/save-dept-object")
    public String saveDeptObject(Dept dept) {
        String url = "http://localhost:8001/dept/add";
        String postForObject = restTemplate.postForObject(url, dept, String.class);
        log.info("stringResponseEntity:{}", postForObject);
        return postForObject;
    }


    @PostMapping("/save-dept-exchange")
    public String saveDeptWithExchange(Dept dept) {
        String url = "http://localhost:8001/dept/add";
        HttpEntity<Dept> entity = new HttpEntity<Dept>(dept);
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        log.info("exchange:{}", exchange);
        return exchange.getBody();
    }
}
