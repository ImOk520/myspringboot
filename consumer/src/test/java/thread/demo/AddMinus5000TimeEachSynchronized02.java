package thread.demo;

import cn.hutool.core.lang.Console;

public class AddMinus5000TimeEachSynchronized02 {
    static int counter = 0;
    static final Object room = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (room){
                for (int i = 0; i<5000; i++){

                    counter++;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (room){
                for (int i = 0; i<5000; i++){
                    counter--;
                }
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Console.log(counter);
    }
 }
