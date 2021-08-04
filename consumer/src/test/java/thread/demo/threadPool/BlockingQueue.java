package thread.demo.threadPool;

import thread.demo.ConsoleUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    // 1、任务队列
    private Deque<T> queue = new ArrayDeque<>();

    // 2、锁
    private ReentrantLock lock = new ReentrantLock();

    // 3、生产者的条件变量 (当阻塞队列塞满任务的时候, 没有空间, 此时进入条件变量中等待)
    private Condition fullWaitSet = lock.newCondition();

    // 4、消费者的条件变量 (当没有任务可以消费的时候, 进入条件变量中等待)
    private Condition emptyWaitSet = lock.newCondition();

    // 5、阻塞队列的容量
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    // 获取队列大小
    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    // 从阻塞队列中获取任务, 如果没有任务,会一直等待
    public T take() {
        lock.lock();
        try {
            // 阻塞队列是否为空
            while (queue.isEmpty()) {
                // 进入消费者的条件变量中等待,此时没有任务供消费
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 阻塞队列不为空, 获取队列头部任务
            T t = queue.removeFirst();
            fullWaitSet.signal(); // 唤醒生产者进行生产, 此时阻塞队列没有满
            return t;
        } finally {
            lock.unlock();
        }
    }

    // 从阻塞队列中获取任务, 如果没有任务, 会等待指定的时间
    public T poll(long timeout, TimeUnit unit) {
        lock.lock();
        try {
            // 将timeout统一转换为纳秒
            long nanos = unit.toNanos(timeout);
            while (queue.isEmpty()) {
                try {
                    // 表示超时, 无需等待, 直接返回null
                    if (nanos <= 0) {
                        return null;
                    }
                    // 返回值的时间(剩余时间) = 等待时间 - 经过时间 所以不存在虚假唤醒(时间还没等够就被唤醒,然后又从新等待相同时间)
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signal(); // 唤醒生产者进行生产, 此时阻塞队列没有满
            return t;
        } finally {
            lock.unlock();
        }
    }

    // 往阻塞队列中添加任务
    public void put(T task) {
        lock.lock();
        try {
            // 阻塞队列是否满了
            while (queue.size() == capacity) {
                try {
                    ConsoleUtil.print("等待进入阻塞队列...");
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(task);
            ConsoleUtil.print("加入任务阻塞队列 {}" + task);
            emptyWaitSet.signal(); // 此时阻塞队列中有任务了, 唤醒消费者进行消费任务
        } finally {
            lock.unlock();
        }
    }

    // 往阻塞队列中添加任务(带超时)
    public boolean offer(T task, long timeout, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            while (queue.size() == capacity) {
                try {
                    if (nanos <= 0) {
                        return false;
                    }
                    ConsoleUtil.print("等待进入阻塞队列"+ task +"...");
                    nanos = fullWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ConsoleUtil.print("加入任务阻塞队列" + task);
            queue.addLast(task);
            emptyWaitSet.signal(); // 此时阻塞队列中有任务了, 唤醒消费者进行消费任务
            return true;
        } finally {
            lock.unlock();
        }
    }

    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try {
            // 判断队列是否满
            if (queue.size() == capacity) {
                rejectPolicy.reject(this, task);
            } else {
                // 有空闲
                ConsoleUtil.print("加入任务队列" + task);
                queue.addLast(task);
                emptyWaitSet.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
