package thread;

import cn.hutool.core.lang.Console;

public class Thread12_DeadThread implements Runnable {

    boolean flag = true;

    static Object obj1 = new Object();
    static Object obj2 = new Object();

    @Override
    public void run() {
        if (flag) {
            synchronized (obj1) {
                try {
                    Thread.sleep(10);
                    Console.log("flag为true,线程：" + Thread.currentThread().getName() + "获取到obj1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2){
                    Console.log(Thread.currentThread().getName()+ "获取到obj2");
                }
            }
        }
        if (!flag) {
            synchronized (obj2) {
                try {
                    Thread.sleep(10);
                    Console.log("flag为false,线程：" + Thread.currentThread().getName() + "获取到obj2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1){
                    Console.log(Thread.currentThread().getName()+ "获取到obj1");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread12_DeadThread t1 = new Thread12_DeadThread();
        Thread12_DeadThread t2 = new Thread12_DeadThread();
        t1.flag = true;
        t2.flag = false;
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
