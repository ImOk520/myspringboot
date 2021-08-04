package thread.demo;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            LockSupport.park();
            ConsoleUtil.print("1");
        }, "t1");
        t1.start();

        new Thread(() -> {
            ConsoleUtil.print("2");
            LockSupport.unpark(t1);
        },"t2").start();
    }
}
