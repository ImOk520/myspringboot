package thread.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class TestParkUnpark02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            ConsoleUtil.print("start...");
            try {
                TimeUnit.MILLISECONDS.sleep(2000);//t1睡眠了一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ConsoleUtil.print("park...");
            LockSupport.park();//t1线程一秒后暂停
            ConsoleUtil.print("resume...");
        }, "t1");
        t1.start();

        TimeUnit.MILLISECONDS.sleep(1000);//主线程睡眠二秒
        ConsoleUtil.print("unpark...");
        LockSupport.unpark(t1);//二秒后由主线程恢复t1线程的运行
    }
}
