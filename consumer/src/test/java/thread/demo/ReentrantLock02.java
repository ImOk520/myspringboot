package thread.demo;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock02 {
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1  进入lock。。。。。");
                lock.lockInterruptibly();     //可打断lock
                System.out.println("睡眠结束了。。。。");
            } catch (InterruptedException e) {
                System.out.println("t1线程被打断了");
                e.printStackTrace();
            }finally {
                lock.unlock();   //解锁
            }
        }, "t1");

        lock.lock();
        t1.start();
        Thread.sleep(1000);
        System.out.println("打断t1 进程");
        t1.interrupt();
    }
}
