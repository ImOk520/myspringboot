package GOF.observer.demo4;

import java.util.Observable;

/**
 * 被观察者
 * Feng, Ge 2021/4/20 0020 16:08
 */
public class NumObservable extends Observable {
    int data = 0;

    public void setData(int i) {
        data = i;
        setChanged();    //标记此 Observable对象为已改变的对象
        notifyObservers();    //通知所有观察者
    }
}
