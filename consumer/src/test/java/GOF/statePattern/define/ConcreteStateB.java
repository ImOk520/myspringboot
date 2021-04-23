package GOF.statePattern.define;


/**
 * 具体状态类 B
 */
class ConcreteStateB extends State {
    public void Handle(Context context) {
        System.out.println("当前状态是 B.");
        // 改变状态
        context.setState(new ConcreteStateA());
    }
}
