package thread.demo.threadPool;

import thread.demo.ConsoleUtil;

import java.util.concurrent.TimeUnit;

public class TestPool {
    public static void main(String[] args) {
        Pool threadPool = new Pool(1, 1000, TimeUnit.MILLISECONDS, 1, new RejectPolicy<Runnable>() {
            @Override
            public void reject(BlockingQueue<Runnable> queue, Runnable task) {
                // 拒绝策略
                // 1、死等
                // queue.put(task);

                // 2、带超时等待
                queue.offer(task, 2000, TimeUnit.MILLISECONDS);

                // 3、让调用者放弃任务执行
                // log.debug("放弃-{}", task);

                // 4、让调用者抛弃异常
                // throw new RuntimeException("任务执行失败" + task);

                // 5、让调用者自己执行任务
                // task.run();
            }
        });
        // 创建5个任务
        for (int i = 0; i < 4; i++) {
            int j = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ConsoleUtil.print("" + j);
                }
            });
        }
    }
}
