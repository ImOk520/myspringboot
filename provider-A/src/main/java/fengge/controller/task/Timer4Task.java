package fengge.controller.task;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用TimerTask创建定时任务
 * Feng, Ge 2021/6/18 0018 15:19
 */
public class Timer4Task {

    static long count = 0;
    public static void main(String[] args) {
        TimerTask timer4Task = new TimerTask() {
            @Override
            public void run() {
                count++;
                System.out.println(count);
            }
        };
        //创建timer对象设置间隔时间
        Timer timer = new Timer();
        // 间隔天数
        long delay = 0;
        // 间隔毫秒数
        long period = 1000;
        timer.scheduleAtFixedRate(timer4Task, delay, period);
    }
}
