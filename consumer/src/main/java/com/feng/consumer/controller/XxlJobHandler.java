package com.feng.consumer.controller;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * Feng, Ge 2020/11/19 0019 14:00
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class XxlJobHandler{

    @XxlJob("demoHandler")
    public ReturnT<Object> run (Object s) throws Exception {
        XxlJobLogger.log("xxl-job测试任务开始执行。【args: {}】", s);
        try {
            System.out.println("执行一次xxl-job打印任务！");
            XxlJobLogger.log("xxl-job测试任务执行结束。");
            return null;
        } catch (Exception e) {
            XxlJobLogger.log("xxl-job测试任务执行出错!", e);
            return null;
        }
    }
}