package thread.demo;

public class BigRoom {
    public void sleep() throws InterruptedException {
        synchronized (this) {
            ConsoleUtil.print("sleeping 2 小时");
            Thread.sleep(2000);
        }
    }

    public void study() throws InterruptedException {
        synchronized (this) {
            ConsoleUtil.print("study 1 小时");
            Thread.sleep(6000);
        }
    }
}
