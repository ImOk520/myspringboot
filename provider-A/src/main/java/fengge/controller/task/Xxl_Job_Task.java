package fengge.controller.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 通过xxl-job实现分布式定时任务
 * Feng, Ge 2021/6/18 0018 16:19
 */
//@JobHandler(value="xxl_Job_Task")
//@Component
//public class Xxl_Job_Task extends IJobHandler {
//
//    static int count;
//    @Override
//    public ReturnT<String> execute(String param) throws Exception {
//        System.out.println("xxl-job 执行job任务"+count++);
//        return SUCCESS;
//    }
//}


@Component
@Slf4j
@RequiredArgsConstructor
public class Xxl_Job_Task{

    static int count;

    @XxlJob("xxl_Job_Task")
    public ReturnT<Object> run (Object s) throws Exception {
        System.out.println("xxl-job 执行job任务"+count++);
        return null;
    }

}