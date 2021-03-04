package thread;

/**
 * Feng, Ge 2021/3/1 0001 15:27
 */
public class Thread01 {
    public static void main(String[] args) {
        Thread testThread = new Thread(() -> {
            System.out.println("testThread当前线程组名字：" +
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字：" +
                    Thread.currentThread().getName());
        });
        testThread.start();
        System.out.println("执⾏main⽅法线程名字：" + Thread.currentThread().getName());
    }


}
