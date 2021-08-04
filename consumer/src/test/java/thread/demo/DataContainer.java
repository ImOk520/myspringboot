package thread.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class DataContainer {
    private Object data;
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock r = rw.readLock();
    private ReentrantReadWriteLock.WriteLock w = rw.writeLock();

    public Object read() throws InterruptedException {
        ConsoleUtil.print("获取读锁...");
        r.lock();
        try {
            ConsoleUtil.print("读取");
            TimeUnit.SECONDS.sleep(1);
            return data;
        } finally {
            ConsoleUtil.print("释放读锁...");
            r.unlock();
        }
    }

    public void write() throws InterruptedException {
        ConsoleUtil.print("获取写锁...");
        w.lock();
        try {
            ConsoleUtil.print("写入");
            TimeUnit.SECONDS.sleep(1);
        } finally {
            ConsoleUtil.print("释放写锁...");
            w.unlock();
        }
    }
}
