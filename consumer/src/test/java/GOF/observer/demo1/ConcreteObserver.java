package GOF.observer.demo1;

/**
 * Feng, Ge 2021/4/20 0020 14:54
 */
public class ConcreteObserver implements Observer {

    @Override
    public void update() {
        System.out.println("收到消息，进行处理");
    }
}
