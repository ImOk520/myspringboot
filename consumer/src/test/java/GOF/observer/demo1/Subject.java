package GOF.observer.demo1;

import java.util.Vector;

/**
 * Feng, Ge 2021/4/20 0020 14:34
 */
public class Subject {

    //观察者数组
    private Vector<Observer> observerVector = new Vector<>();

    //增加一个观察者
    public void addObserver(Observer observer) {
        this.observerVector.add(observer);
    }

    //删除一个观察者
    public void deleteObserver(Observer observer) {
        this.observerVector.remove(observer);
    }

    //通知所有观察者
    public void notifyObserver() {
        for(Observer observer : this.observerVector) {
            observer.update();
        }
    }
}
