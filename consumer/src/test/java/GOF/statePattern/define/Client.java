package GOF.statePattern.define;

/**
 * 状态模式 客户端
 */
public class Client {
    public static void main(String[] args) {
        State state = new ConcreteStateA();
        //创建环境
        Context context = new Context(state);
        //处理请求
        context.Handle();
        context.Handle();
        context.Handle();
        context.Handle();
    }
}
