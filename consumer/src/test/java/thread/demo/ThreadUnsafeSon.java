package thread.demo;

import java.util.ArrayList;

class ThreadUnsafeSon {
    public static void main(String[] args) {
        ThreadSafeSubClass test = new ThreadSafeSubClass();
        for(int i = 0 ; i < 1; i++){
            new Thread(()->{
                test.method1(20000);
            }, "Thread" + (i + 1)).start();
        }
    }
}

class ThreadSafe {
    public void method1(int loopNumber) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < loopNumber; i++) {
            method2(list);
            method3(list);
        }
    }
    public void method2(ArrayList<String> list) {
        list.add("1");
        System.out.println((Thread.currentThread() + "1"));
    }
    public void method3(ArrayList<String> list) {
        list.remove(0);
        System.out.println((Thread.currentThread() + "0"));
    }
}

class ThreadSafeSubClass extends ThreadSafe{
    @Override
    public void method3(ArrayList<String> list) {
        new Thread(() -> {
            list.remove(0);
            System.out.println((Thread.currentThread() + "0"));
        }).start();
    }
}
