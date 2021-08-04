package thread.demo;

public class MyNonReentrantLockTest {
    public static void main(String[] args) {
        MyNonReentrantLock lock = new MyNonReentrantLock();
        new Thread(() -> {
            lock.lock();
            ConsoleUtil.print(Thread.currentThread() + "locking...");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                ConsoleUtil.print(Thread.currentThread() + "unlocking...");
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                ConsoleUtil.print(Thread.currentThread() + "locking...");
            } finally {
                ConsoleUtil.print(Thread.currentThread() + "unlocking...");
                lock.unlock();
            }
        }, "t2").start();
    }
}
