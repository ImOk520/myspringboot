package thread.demo;

import cn.hutool.core.lang.Console;

public class Interrupter01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            Console.log("t1 sleep.....");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t1.start();
        Thread.sleep(1000);
        Console.log("t1 线程被打断前的打断标记{}", t1.isInterrupted());
        Console.log("main 线程开始中断t1 线程.....");
        t1.interrupt();
        Console.log("t1 线程被打断后的打断标记{}", t1.isInterrupted());
    }
}
