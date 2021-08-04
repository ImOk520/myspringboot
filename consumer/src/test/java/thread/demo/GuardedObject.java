package thread.demo;


/**
 * 该类中就是我们上一节使用的wait/notifyAll正确使用方法
 */
public class GuardedObject {
    // 结果(因为我们这个结果可以是任意对象，所以这里设置为Object)
    private Object response;

    // 获取结果的方法
    public Object get() throws InterruptedException {
        // 这里为什么加while而不是直接wait呢?
        while (null == response) {
            // 这里为什么加锁呢？
            // 1、保护性暂停模式是两个线程对同一个线程进行操作的，
            // 所以多个线程之间要对同一个对象操作，那么要加锁
            // 2、wait、notify、notifyAll三个方法都必须是线程为资源锁的owner
            // 才能调用否则会报错误IllegalMonitorStateException
            synchronized (this) {
                this.wait();
            }
        }
        return response;
    }

    // 产生结果的方法
    public void complete(Object response) {
        synchronized (this) {
            // 给结果成员变量赋值
            this.response = response;
            this.notifyAll();
        }
    }
}

