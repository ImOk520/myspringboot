package thread.demo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;

public class TwoPhaseTermination {
    private Thread monitor;

    public void start(){
        monitor = new Thread(() -> {
           while(true) {
               Thread currentThread = Thread.currentThread();
               boolean currentThreadInterrupted = currentThread.isInterrupted();
               if(currentThreadInterrupted) {
                   Console.log(DateUtil.now() + "料理后事");
                   break;
               }
               try {
                   Thread.sleep(1000);
                   Console.log(DateUtil.now() + "执行监控");
               } catch (InterruptedException e) {
                   e.printStackTrace();
                   // 重新设置打断状态
                   currentThread.interrupt();
               }
           }
        });
        monitor.start();
    }

    public void stop(){
        monitor.interrupt();
    }
}
