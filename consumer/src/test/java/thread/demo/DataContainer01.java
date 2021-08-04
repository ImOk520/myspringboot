package thread.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class DataContainer01 {
    private Object data;
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock r = rw.readLock();
    private ReentrantReadWriteLock.WriteLock w = rw.writeLock();

    public Object read() throws InterruptedException {
        ConsoleUtil.print("获取读锁...");
        r.lock();
        try {
            ConsoleUtil.print("准备升级成读锁");
            TimeUnit.SECONDS.sleep(1);
            w.lock();
            return data;
        } finally {
            ConsoleUtil.print("释放读写锁...");
            w.unlock();
            r.unlock();
        }
    }

    public void write() throws InterruptedException {
        ConsoleUtil.print("获取写锁...");
        w.lock();
        try {
            ConsoleUtil.print("准备降级成读锁");
            TimeUnit.SECONDS.sleep(1);
            r.lock();
        } finally {
            ConsoleUtil.print("释放读写锁...");
            r.unlock();
            w.unlock();
        }
    }
}
