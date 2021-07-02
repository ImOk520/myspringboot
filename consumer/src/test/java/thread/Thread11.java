package thread;

public class Thread11 {
    public static void main(String[] args) {
        Ticket tt = new Ticket();
        new Thread(tt, "甲").start();
        new Thread(tt, "乙").start();
    }
}

class Ticket implements Runnable {
    private int ticketCount = 10;
    @Override
    public void run() {
        while (ticketCount > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第【" + (10 - ticketCount + 1) + "】张火车票");
            ticketCount--;
        }
    }
}

