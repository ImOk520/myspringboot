package thread.demo;

import cn.hutool.core.lang.Console;

public class WaitTest02 {

    static final Object room = new Object();
    static boolean hasCigarette = false;// 有没有烟
    static boolean hasTakeout = false;
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (room) {
                    Console.log("有烟没？ " + hasCigarette);
                    if (!hasCigarette) {
                        Console.log("没烟先歇会: " + hasCigarette);
                        try {
                            room.wait(2000);
                        } catch (InterruptedException e) {
                            // 该异常什么时候会抛出呢?就是其他线程调用interrupt方法
                            // 它也会让正在wait的线程被打断，打断之后，我们这边接到异常
                            // 就知道该线程被打断了,也可以对打断标记进行判断，于是可以继续进行处理。
                            // 当然了，更合理的方法是其他线程调用notify方法来唤醒
                            // 正在wait的线程
                            e.printStackTrace();
                        }
                    }
                    Console.log("有烟没？ " + hasCigarette);
                    if (hasCigarette) {
                        Console.log(Thread.currentThread().getName() + ":可以干活了: " + hasCigarette);
                    }
                }
            }
        }, "小南").start();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (room) {
                        Console.log(Thread.currentThread().getName() +":可以干活了 " + hasCigarette);
                    }
                }
            },"其他人").start();
        }
        Thread.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 下面的代码可以加锁吗？
                synchronized (room) {
                    hasCigarette = true;
                    Console.log(Thread.currentThread().getName() +":烟到了 " + hasCigarette);
                    // 这里要要注意，
                    // notify/notifyAll只能唤醒wait状态下的线程
                    // 对blocked状态下的线程毫无作用。
                    // 所以不管是wait还是notify/notifyAll，
                    // 他们都有一个前提就是线程都必须获得了对象锁。成为了owner之后才能调用这3个方法
                    // 所以这里要在synchronized代码块里调用notify，否则将抛出非法状态异常
                    room.notify();
                }
            }
        },"送烟的").start();
    }
}

