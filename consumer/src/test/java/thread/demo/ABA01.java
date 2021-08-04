package thread.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ABA01 {
    static AtomicReference<String> ref = new AtomicReference<>("A");

    public static void main(String[] args) {
        new Thread(() -> {
            String pre = ref.get();
            System.out.println("change");
            try {
                other();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //把ref中的A改为C
            System.out.println("change A->C " + ref.compareAndSet(pre, "C"));
        }).start();
    }

    static void other() throws InterruptedException {
        new Thread(() -> {
            // 此时ref.get()为A,此时共享变量ref也是A,没有被改过, 此时CAS
            // 可以修改成功, B
            System.out.println("change A->B " + ref.compareAndSet(ref.get(), "B"));
        }).start();
        Thread.sleep(500);
        new Thread(() -> {
            // 同上, 修改为A
            System.out.println("change B->A " + ref.compareAndSet(ref.get(), "A"));
        }).start();
    }
}
