package com.feng.consumer.controller;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Feng, Ge 2020/11/19 0019 14:00
 */
@JobHandler(value = "demoHandler")
@Component
@Slf4j
@RequiredArgsConstructor
public class XxlJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String s1) throws Exception {
        XxlJobLogger.log("xxl-job测试任务开始执行。【args: {}】", s1);
        try {
            System.out.println("执行一次xxl-job打印任务！");
            XxlJobLogger.log("xxl-job测试任务执行结束。");
            return SUCCESS;
        } catch (Exception e) {
            XxlJobLogger.log("xxl-job测试任务执行出错!", e);
            return FAIL;
        }
    }
}