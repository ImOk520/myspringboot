package thread;

/**
 * ⼀个线程必然存在于⼀个线程组中，那么当线程和线程组的优
 * 先级不⼀致的时候将会怎样呢？
 * 如果某个线程优先级⼤于线程所在线程组的最⼤优先级，那么该线程的优先
 * 级将会失效，取⽽代之的是线程组的最⼤优先级。
 */
public class Thread04 {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup,"thread");
        thread.setPriority(9);
        System.out.println("我是线程组的优先级"+threadGroup.getMaxPriority());
        System.out.println("我是线程的优先级"+thread.getPriority());
        System.out.println("我是线程组的名称" + threadGroup.getName());
        System.out.println("我是当前线程组的名称" + Thread.currentThread().getThreadGroup().getName());
    }
}
