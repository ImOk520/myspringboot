package thread.demo;


/**
 * 该类中就是我们上一节使用的wait/notifyAll正确使用方法
 */
public class GuardedObject01 {
    // 结果(因为我们这个结果可以是任意对象，所以这里设置为Object)
    private Object response;

    // 获取结果的方法
    public Object get(long timeout) throws InterruptedException {
        synchronized (this) {
            // 开始时间
            long beginTime = System.currentTimeMillis();
            // 已经等待的时间
            long passedTime = 0;
            while (null == response) {
                // 这一轮循环应该等待的时间
                long waitTime = timeout - passedTime;
                // 等待的时间超过了最大等待时间，退出循环
                if (waitTime <= 0) {
                    break;
                }

                // 这里为啥不用timeout？
                // 考虑到虚假唤醒的情况，
                // 例如当该线程在14:44：44被虚假唤醒了
                // 然后它就执行下面的代码再次进入while的时候，此时过去了1s，
                // 于是它应该再等待1s，而不是原来的2s
                // 避免虚假唤醒时再次等待的时间会变长,即被虚假唤醒时的耗时也算在本次wait的时间之内。
                this.wait(waitTime);  // 虚假唤醒

                // 已经等待的时间
                passedTime = System.currentTimeMillis() - beginTime;
            }
            return response;
        }
    }

    // 产生结果的方法
    public void complete(Object response) {
        synchronized (this) {
            // 给结果成员变量赋值
            this.response = response;
            this.notifyAll();
        }
    }
}

