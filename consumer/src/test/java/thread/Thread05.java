package thread;

/**
 * 线程组统⼀异常处理
 */
public class Thread05 {
    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("group1") {
            // 继承ThreadGroup并重新定义以下⽅法
            // 在线程成员抛出unchecked exception
            // 会执⾏此⽅法
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };
        // 这个线程是threadGroup1的⼀员
        Thread thread1 = new Thread(threadGroup1, new Runnable() {
            public void run() {
                // 抛出unchecked异常
                throw new RuntimeException("测试异常");
            }
        });
        thread1.start();
    }
}
