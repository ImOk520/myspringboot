package thread.demo;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class ABA03 {
    public static void main(String[] args) throws InterruptedException {
        GarbageBag bag = new GarbageBag("装满了垃圾");

        // 参数2 mark 可以看作一个标记，表示垃圾袋满了
        AtomicMarkableReference<GarbageBag> ref = new AtomicMarkableReference<>(bag, true);
        ConsoleUtil.print("主线程 start...");

        GarbageBag prev = ref.getReference();
        ConsoleUtil.print(prev.toString());

        new Thread(() -> {
             ConsoleUtil.print("打扫卫生的线程 start...");
            bag.setDesc("空垃圾袋");
            while (!ref.compareAndSet(bag, bag, true, false)) {
            }
             ConsoleUtil.print(bag.toString());
        }).start();

        Thread.sleep(1000);
         ConsoleUtil.print("主线程想换一只新垃圾袋？");

        boolean success = ref.compareAndSet(prev, new GarbageBag("空垃圾袋"), true, false);
         ConsoleUtil.print("换了么？" + success);
         ConsoleUtil.print(ref.getReference().toString());
    }
}

class GarbageBag {
    String desc;

    public GarbageBag(String desc) {
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return super.toString() + " " + desc;
    }
}
