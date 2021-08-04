package thread.demo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;

public class WaitTest01 {

    static final Object room = new Object();
    static boolean hasCigarette = false;// 有没有烟
    static boolean hasTakeout = false;
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (room) {
                    Console.log(DateUtil.now() + "有烟没？ " + hasCigarette);
                    if (!hasCigarette) {
                        Console.log(DateUtil.now() + "没烟先歇会: " + hasCigarette);
                        try {
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Console.log(DateUtil.now() + "有烟没？ " + hasCigarette);
                    if (hasCigarette) {
                        Console.log(DateUtil.now() + Thread.currentThread().getName() + ":可以干活了: " + hasCigarette);
                    }
                }
            }
        }, "小南").start();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (room) {
                        Console.log(DateUtil.now() + Thread.currentThread().getName() +":可以干活了 " + hasCigarette);
                    }
                }
            },"其他人").start();
        }

        Thread.sleep(1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 下面的代码可以加锁吗？
                hasCigarette = true;
                Console.log(DateUtil.now() + Thread.currentThread().getName() +":烟到了 " + hasCigarette);
            }
        },"送烟的").start();
    }
}

