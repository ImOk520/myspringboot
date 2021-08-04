package thread.demo;

public class MulLocks {
    public static void main(String[] args) {
        BigRoom01 bigRoom = new BigRoom01();

        new Thread(() -> {
            try {
                bigRoom.study();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "小南").start();

        new Thread(() -> {
            try {
                bigRoom.sleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "小女").start();
    }
}
