package GOF.producer_consumer_model;

import cn.hutool.core.lang.Console;

/**
 * 生产者消费者模式演示
 * Feng, Ge 2021/7/5 0005 10:35
 */
public class Container {

    private String baozi;
    private boolean flag = true;

    public synchronized void play(String baozi) throws InterruptedException {
        if (!flag) {
            this.wait();
        }
        Thread.sleep(1000);
        this.baozi = baozi;
        Console.log("生产" + baozi);
        this.notify();
        this.flag = false;
    }

    public synchronized void eat() throws InterruptedException {
        if (flag) {
            this.wait();
        }
        Thread.sleep(1000);
        this.notify();
        this.flag = true;
    }
}

class Player implements Runnable{
    private Container container;

    public Player(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            if(i%2 == 0){
                try {
                    container.play("肉馅的包子");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    container.play("素馅的包子");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable {
    private Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                container.eat();
                Console.log("吃个包子");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Container container = new Container();
        Player player = new Player(container);
        Consumer consumer = new Consumer(container);
        Thread t1 = new Thread(player);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
