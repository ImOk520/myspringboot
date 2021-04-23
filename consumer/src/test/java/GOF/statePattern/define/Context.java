package GOF.statePattern.define;

/**
 * 上下文环境类
 */
class Context {
    private State state;

    //定义环境类的初始状态
    public Context(State state) {
        this.state = state;
    }

    //设置新状态
    public void setState(State state) {
        this.state = state;
    }

    //读取状态
    public State getState() {
        return (state);
    }

    //对请求做处理
    public void Handle() {
        state.Handle(this);
    }
}

