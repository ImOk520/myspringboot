package thread.demo;


class Room {
    int value = 0;

    public void increment() {
        synchronized (this) {
            value++;
        }
    }

    public void decrement() {
        synchronized (this) {
            value--;
        }
    }

    public int get() {
        // 这里虽是读操作，也要加锁，保证读取的是最终结果
//        synchronized (this) {
            return value;
//        }
    }
}