package GOF.observer.demo5;

import java.util.Observable;
import java.util.Observer;

/**
 * Feng, Ge 2021/4/20 0020 16:50
 */
public class NotOnlyObservableButAlsoObserver_B extends Observable implements Observer {

    int data = 0;

    public void setData (int i) {
        data = i;
        setChanged();         //标记此 Observable对象为已改变的对象
        notifyObservers();    //通知所有观察者
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("同时，A反过来通知B自己的变化");
    }
}
