package JVM;

/**
 * 栈上分配测试
 * 参数设置
 *      -Xms1G -Xmx1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails (未开启栈上分配)
 *      -Xms1G -Xmx1G -XX:+DoEscapeAnalysis -XX:+PrintGCDetails (开启栈上分配)
 */
public class StackAllocation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        //查看执行时间
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + "ms");
        //为了查看堆内存中对象的个数，线程 sleep
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void alloc() {
        //此时，这个对象未发生逃逸，所以这个对象会分配到栈空间上
        User user = new User();
    }
}

class User {

}

