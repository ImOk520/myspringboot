package fengge.controller.task;

/**
 * 使用线程创建定时任务
 * Feng, Ge 2021/6/18 0018 15:16
 */
public class ThreadTask {

    public static class Demo01 {
        static long count = 0;

        public static void main(String[] args) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                            count++;
                            System.out.println(count);
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}