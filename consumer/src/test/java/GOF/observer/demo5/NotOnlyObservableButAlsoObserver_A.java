package GOF.observer.demo5;

import java.util.Observable;
import java.util.Observer;

/**
 * 既是观察者又是被观察者
 * Feng, Ge 2021/4/20 0020 16:39
 */
public class NotOnlyObservableButAlsoObserver_A extends Observable implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        NotOnlyObservableButAlsoObserver_B b = (NotOnlyObservableButAlsoObserver_B) o;     //获取被观察者对象
        System.out.println("A监听到B数据变化：" + b.data);

        setChanged();
        notifyObservers();    //自己观察到数据变化，通知自己的观察者
    }
}
