package GOF.statePattern.define;


/**
 * 具体状态类 A
 */
class ConcreteStateA extends State {
    public void Handle(Context context) {
        System.out.println("当前状态是 A.");
        // 改变状态
        context.setState(new ConcreteStateB());
    }
}
