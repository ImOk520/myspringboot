package GOF.statePattern.thread;

/**
 * Feng, Ge 2021/4/22 0022 16:09
 */
//具体状态类：新建状态
class New extends ThreadState {
    public New() {
        stateName = "新建状态";
        System.out.println("当前线程处于：新建状态.");
    }

    public void start(ThreadContext context) {
        System.out.print("调用start()方法-->");
        if (stateName.equals("新建状态")) {
            // 启动新线程，并改变状态
            context.setState(new Runnable());
        } else {
            System.out.println("当前线程不是新建状态，不能调用start()方法.");
        }
    }
}
