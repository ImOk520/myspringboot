package thread.demo;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class ABA04 {
    //指定版本号
    static AtomicMarkableReference<String> ref = new AtomicMarkableReference<>("A", true);

    public static void main(String[] args) {
        new Thread(() -> {
            String pre = ref.getReference();
            System.out.println("change");
            try {
                other();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //把str中的A改为C,并比对版本号，如果版本号相同，就执行替换，并让版本号+1
            System.out.println("change A->C mark " + ref.compareAndSet(pre, "C", true, false));
        }).start();
    }

    static void other() throws InterruptedException {
        new Thread(() -> {
            System.out.println("change A->A mark " + ref.compareAndSet(ref.getReference(), "A", true, false));
        }).start();
    }
}
