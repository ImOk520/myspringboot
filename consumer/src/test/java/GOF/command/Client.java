package GOF.command;

public class Client {
    public static void main(String[] args) {
        ConcreteReceiver01 concreteReceiver01 = new ConcreteReceiver01();
        ConcreteCommand concreteCommand01 = new ConcreteCommand(concreteReceiver01);
        Invoker invoker01 = new Invoker(concreteCommand01);
        invoker01.call();

        ConcreteReceiver02 concreteReceiver02 = new ConcreteReceiver02();
        ConcreteCommand concreteCommand02 = new ConcreteCommand(concreteReceiver02);
        Invoker invoker02 = new Invoker(concreteCommand02);
        invoker02.call();
    }
}
