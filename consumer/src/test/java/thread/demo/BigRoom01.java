package thread.demo;

public class BigRoom01 {
    private final Object studyObj = new Object();
    private final Object sleepObj = new Object();


    public void sleep() throws InterruptedException {
        synchronized (sleepObj) {
            ConsoleUtil.print("sleeping 2 小时");
            Thread.sleep(2000);
        }
    }

    public void study() throws InterruptedException {
        synchronized (studyObj) {
            ConsoleUtil.print("study 1 小时");
            Thread.sleep(6000);
        }
    }
}
