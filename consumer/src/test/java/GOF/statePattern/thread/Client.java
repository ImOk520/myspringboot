package GOF.statePattern.thread;

/**
 * 状态模式 客户端
 */
public class Client {
    public static void main(String[] args) {
        ThreadContext context = new ThreadContext();
        context.startWork();
    }
}
