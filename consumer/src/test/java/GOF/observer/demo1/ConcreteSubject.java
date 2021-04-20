package GOF.observer.demo1;

/**
 * Feng, Ge 2021/4/20 0020 14:38
 */
public class ConcreteSubject extends Subject {

    //具体业务
    public void doSomething() {
        //...
        super.notifyObserver();
    }
}