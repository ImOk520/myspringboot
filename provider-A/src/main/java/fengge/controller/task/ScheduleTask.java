package fengge.controller.task;

import cn.hutool.core.lang.Console;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Scheduled 注解实现定时任务
 * Feng, Ge 2021年6月18日15:11:06
 */
@Configuration // 这里使用@Component也行
public class ScheduleTask {

    //添加定时任务-- 50分钟执行一次
    @Scheduled(fixedRate = 5 * 1000)
    private void updateTask() {
//        Console.log("@Scheduled 注解实现定时任务 执行-------------------");
    }
}