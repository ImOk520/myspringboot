package thread.demo.threadPool;


import thread.demo.ConsoleUtil;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Pool {
    // 阻塞任务队列
    private BlockingQueue<Runnable> taskQueue;

    // 线程集合
    private HashSet<Worker> workers = new HashSet<>();

    // 核心线程数
    private int coreSize;

    // 获取任务的超时时间
    private long timeout;

    private TimeUnit timeUnit;

    // 拒绝策略
    private RejectPolicy<Runnable> rejectPolicy;

    public Pool(int coreSize, long timeout, TimeUnit timeUnit, int queueCapacity, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockingQueue<>(queueCapacity);
        this.rejectPolicy = rejectPolicy;
    }

    // 执行任务
    public void execute(Runnable task) {
        synchronized (workers) {
            // 当任务没有超过线程数, 说明当前worker线程可以消费这些任务, 不用将任务加入到阻塞队列中
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                ConsoleUtil.print("新增 worker" + worker + task);
                workers.add(worker);
                worker.start();
            } else {
                // taskQueue.put(task); // 这一种死等
                // 拒绝策略
                // 1、死等
                // 2、带超时等待
                // 3、让调用者放弃任务执行
                // 4、让调用者抛弃异常
                // 5、让调用者自己执行任务
                taskQueue.tryPut(rejectPolicy, task);

            }
        }
    }


    class Worker extends Thread {
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            // 执行任务
            // 1): 当task不为空, 执行任务
            // 2): 当task执行完毕, 从阻塞队列中获取任务并执行
            //while (task != null || (task = taskQueue.take()) != null) {
            while (task != null || (task = taskQueue.poll(timeout, timeUnit)) != null) {
                try {
                    ConsoleUtil.print("正在执行..." + task);
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    task = null;
                }
            }

            // 将线程集合中的线程移除
            synchronized (workers) {
                ConsoleUtil.print("worker被移除" + this);
                workers.remove(this);
            }
        }
    }
}
