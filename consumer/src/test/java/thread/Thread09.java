package thread;

/**
 * threadLocal是⼀个本地线程副本变量⼯具类。内部是⼀个弱引⽤的Map来维护。
 * ThreadLocal为线程本地变量或线程本地存储。严格来说，ThreadLocal
 * 类并不属于多线程间的通信，⽽是让每个线程有⾃⼰”独⽴“的变量，线程之间互不
 * 影响。它为每个线程都创建⼀个副本，每个线程可以访问⾃⼰内部的副本变量。
 *
 * 可以看到，虽然两个线程使⽤的同⼀个ThreadLocal实例（通过构造⽅法传⼊），
 * 但是它们各⾃可以存取⾃⼰当前线程的⼀个值。
 *
 * 那ThreadLocal有什么作⽤呢？如果只是单纯的想要线程隔离，在每个线程中声明
 * ⼀个私有变量就好了呀，为什么要使⽤ThreadLocal？
 * 如果开发者希望将类的某个静态变量（user ID或者transaction ID）与线程状态关联，则可以考虑使⽤ThreadLocal。
 *
 * 最常⻅的ThreadLocal使⽤场景为⽤来解决数据库连接、Session管理等。数据库连
 * 接和Session管理涉及多个复杂对象的初始化和关闭。如果在每个线程中声明⼀些
 * 私有变量来进⾏操作，那这个线程就变得不那么“轻量”了，需要频繁的创建和关闭
 * 连接。
 *
 * InheritableThreadLocal类与ThreadLocal类稍有不同，Inheritable是继承的意思。
 * 它不仅仅是当前线程可以存取副本值，⽽且它的⼦线程也可以存取这个副本值。
 */
public class Thread09 {

    static class ThreadA implements Runnable {
        private ThreadLocal<String> threadLocal;
        public ThreadA(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }
        @Override
        public void run() {
            threadLocal.set("A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadA输出：" + threadLocal.get());
        }

        static class ThreadB implements Runnable {
            private ThreadLocal<String> threadLocal;
            public ThreadB(ThreadLocal<String> threadLocal) {
                this.threadLocal = threadLocal;
            }
            @Override
            public void run() {
                threadLocal.set("B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadB输出：" + threadLocal.get());
            }
        }
        public static void main(String[] args) {
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            new Thread(new ThreadA(threadLocal)).start();
            new Thread(new ThreadB(threadLocal)).start();
        }
    }
}
