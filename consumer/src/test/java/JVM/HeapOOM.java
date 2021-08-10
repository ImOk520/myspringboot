package JVM;

import thread.demo.ConsoleUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HeapOOM {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);

        new Thread(()-> {
           List<byte[]> list = new ArrayList<>();
           while(true){
               ConsoleUtil.print(Thread.currentThread() + "==");
               byte[] b = new byte[1024 * 1024];
               list.add(b);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }, "t1").start();

        new Thread(()-> {
            while(true){
                ConsoleUtil.print(Thread.currentThread() + "==");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();
    }
}
