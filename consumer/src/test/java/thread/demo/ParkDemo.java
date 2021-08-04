package thread.demo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;

import java.util.concurrent.locks.LockSupport;

import static jodd.util.ThreadUtil.sleep;

public class ParkDemo {
    public static void main(String[] args) {
        park();
    }

    private static void park(){
        Thread t1 = new Thread(()-> {
            Console.log(DateUtil.now() + "开始调用park，暂停任务");
            LockSupport.park();
            Console.log(DateUtil.now() + "park后");
            Console.log(DateUtil.now() + "打断状态" + Thread.interrupted());

            LockSupport.park();
            Console.log(DateUtil.now() + "第二次park，打断状态：" + Thread.currentThread().isInterrupted());
        }, "t1");

        t1.start();
        sleep(1000);
        t1.interrupt();
    }
}
