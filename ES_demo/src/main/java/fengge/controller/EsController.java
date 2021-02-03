package fengge.controller;

import cn.hutool.core.lang.Console;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.*;

/**
 * Feng, Ge 2020-10-13 20:32
 */
@Slf4j
@RequestMapping("/es")
@RestController
public class EsController {

    @Autowired
//    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @ApiOperation("创建索引")
    @PostMapping("/createIndex")
    public void test1() throws IOException {
        // 1.创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("index-2");
        // 2.客户端执行请求
        CreateIndexResponse response = client
                .indices()
                .create(request, RequestOptions.DEFAULT);
        Console.log(response);
    }

}
