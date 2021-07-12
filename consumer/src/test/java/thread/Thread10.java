package thread;

import cn.hutool.core.lang.Console;

/**
 * InheritableThreadLocal 实现多个线程访问ThreadLocal的值
 *
 * InheritableThreadLocal类与ThreadLocal类稍有不同，Inheritable是继承的意思。
 * 它不仅仅是当前线程可以存取副本值，⽽且它的⼦线程也可以存取这个副本值。
 */
public class Thread10 {
    public static void main(String[] args) {
        final ThreadLocal threadLocal = new InheritableThreadLocal();
        threadLocal.set("我是主线程set到threadLocal中的值。");
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                Console.log( "【我是非主线程，从主线程中的threadLocal中取值】：" + threadLocal.get());
            }
        };
        t.start();
    }
}
