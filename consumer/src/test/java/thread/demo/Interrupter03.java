package thread.demo;

import cn.hutool.core.lang.Console;

public class Interrupter03 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while(true){
                Thread current = Thread.currentThread();
                boolean currentInterrupted = current.isInterrupted();
                Console.log("t1的线程状态：{}", currentInterrupted);
                if(currentInterrupted){
                    Console.log("被打断了，线程任务退出！");
                    break;
                }
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
