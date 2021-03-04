package thread;

import org.junit.Test;

/**
 * Java线程的6个状态
 */
public class Thread06 {

    /**
     *  NEW
     * 处于NEW状态的线程此时尚未启动。这⾥的尚未启动指的是还没调⽤Thread实例的start()⽅法
     */
    @Test
    public void test1() {
        Thread thread = new Thread(() -> {});
        System.out.println(thread.getState()); // 输出 NEW
    }

    /**
     *  NEW
     * 处于NEW状态的线程此时尚未启动。这⾥的尚未启动指的是还没调⽤Thread实例的start()⽅法
     */
    @Test
    public void test2() {
        Thread thread = new Thread(() -> {});
        System.out.println(thread.getState()); // 输出 NEW
    }



}
