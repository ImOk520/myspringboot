package thread.demo;

public class RWLock {
    public static void main(String[] args) {
            DataContainer01 dataContainer = new DataContainer01();
            new Thread(() -> {
                try {
                    dataContainer.write();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "t1").start();

            new Thread(() -> {
                try {
                    dataContainer.write();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "t2").start();
        }
}
