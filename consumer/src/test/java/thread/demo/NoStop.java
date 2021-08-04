package thread.demo;

import java.util.concurrent.TimeUnit;

public class NoStop {
    volatile static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while(run){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ConsoleUtil.print("6666666");
            }
        });
        t.start();

        TimeUnit.SECONDS.sleep(1);
        run = false; // 线程t不会如预想的停下来
    }
}
