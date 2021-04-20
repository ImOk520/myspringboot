package GOF.observer.demo1;

/**
 * Feng, Ge 2021/4/20 0020 14:40
 */
public class Client {
    public static void main(String[] args) {
        //创建一个主题
        ConcreteSubject subject = new ConcreteSubject();
        //定义一个观察者
        Observer observer = new ConcreteObserver();
        //观察
        subject.addObserver(observer);
        //开始活动
        subject.doSomething();
    }

}
