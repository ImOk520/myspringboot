package fengge.controller.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 继承Quartz框架中的Job，并重写execute方法
 * Feng, Ge 2021/6/18 0018 15:32
 */
public class SelfJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("quartz Job date:" + System.currentTimeMillis());
    }
}