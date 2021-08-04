package thread.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock03 {
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("尝试获取 lock。。。。。");
            try {
                if(!lock.tryLock(1, TimeUnit.SECONDS)){
                    System.out.println("获取失败");
                    return;
                }
                System.out.println("获取成功");
            } catch (InterruptedException e) {
                System.out.println("获取锁异常");
                e.printStackTrace();
                return;
            }finally {
                lock.unlock();   //解锁
            }
        }, "t1");

        lock.lock();
        System.out.println("000000000");
        t1.start();
    }
}
