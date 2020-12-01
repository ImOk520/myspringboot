package com.feng.consumer.controller;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.feng.pojo.Dept;
import com.mysql.cj.jdbc.Driver;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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

    @GetMapping("/data-source-output")
    public void dataSourceOutput() throws SQLException {
        test();
    }

    public void test() throws SQLException {
//        DataSource dataSourceMysql = SpringContextUtil.getBean(DataSource.class);
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/prescription-new?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("123456");
        HikariDataSource dataSourceMysql = new HikariDataSource(hikariConfig);

        // 生成文件配置
        EngineConfig engineConfig = EngineConfig.builder()
                // 生成文件路径
                .fileOutputDir("D:/")
                // 打开目录
                .openOutputDir(true)
                // 文件类型
                .fileType(EngineFileType.HTML)
                // 生成模板实现
                .produceType(EngineTemplateType.freemarker).build();
        // 生成文档配置（包含以下自定义版本号、描述等配置连接）
        Configuration config = Configuration.builder()
                .version("V1")
                .description("生成文档信息描述")
                .dataSource(dataSourceMysql)
                .engineConfig(engineConfig)
                .produceConfig(getProcessConfig())
                .build();
        // 执行生成
        new DocumentationExecute(config).execute();
    }

    /**
     * 配置想要生成的表+ 配置想要忽略的表
     *
     * @return 生成表配置
     */
    public static ProcessConfig getProcessConfig() {
        // 忽略表名
        List<String> ignoreTableName = Arrays.asList("dept", "dept1");
        // 忽略表前缀，如忽略a开头的数据库表
        List<String> ignorePrefix = Arrays.asList("dept", "dept1");
        // 忽略表后缀
        List<String> ignoreSuffix = Arrays.asList("dept", "dept1");
        return ProcessConfig.builder()
                //根据名称指定表生成
                .designatedTableName(Arrays.asList("tb_his_prescription_record_extend", "tb_his_prescription_detail_extend"))
                //根据表前缀生成
                .designatedTablePrefix(new ArrayList<>())
                //根据表后缀生成
                .designatedTableSuffix(new ArrayList<>())
                //忽略表名
                .ignoreTableName(ignoreTableName)
                //忽略表前缀
                .ignoreTablePrefix(ignorePrefix)
                //忽略表后缀
                .ignoreTableSuffix(ignoreSuffix).build();
    }
}
