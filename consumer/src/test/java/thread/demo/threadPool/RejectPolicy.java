package thread.demo.threadPool;



@FunctionalInterface // 接口中只有一个方法，加上这个注解，实现lambda简写
interface RejectPolicy<T> {
    void reject(BlockingQueue<T> queue, T task);
}
