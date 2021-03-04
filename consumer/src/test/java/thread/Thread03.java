package thread;

import java.util.stream.IntStream;

/**
 * Feng, Ge 2021/3/1 0001 15:27
 */
public class Thread03 {

        public static class T1 extends Thread {
            @Override
            public void run() {
                super.run();
                System.out.println(String.format("当前执⾏的线程是：%s，优先级：%d",
                        Thread.currentThread().getName(),
                        Thread.currentThread().getPriority()));
            }
        }
        public static void main(String[] args) {
            IntStream.range(1, 10).forEach(i -> {
                Thread thread = new Thread(new T1());
                thread.setPriority(i);
                thread.start();
            });
        }

}
