package thread.demo;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.TimeUnit;

public class WaitNotifyTest03 {
    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println(DateUtil.now() + "执行了线程1");
                    try {
                        obj.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(DateUtil.now() + "线程1任务执行完毕");
                }
            }
        },"t1").start();

        System.out.println(DateUtil.now() + "主线程....");
        TimeUnit.MILLISECONDS.sleep(1000);
        synchronized (obj){
            System.out.println(DateUtil.now() + "主线程中途唤醒t1....");
            obj.notifyAll();
        }
    }
}
