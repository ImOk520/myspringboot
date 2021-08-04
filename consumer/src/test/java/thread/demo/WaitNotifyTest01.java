package thread.demo;

import java.util.concurrent.TimeUnit;

public class WaitNotifyTest01 {
    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("执行了线程1");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1任务执行完毕");
                }
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("执行了线程2");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2执行完毕");
                }
            }
        },"t2").start();

        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("主线程唤醒 t1 和（或） t2 线程....");
        synchronized (obj){
            obj.notify();
        }

    }
}
