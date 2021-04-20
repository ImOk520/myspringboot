package GOF.observer.demo4;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者1
 * Feng, Ge 2021/4/20 0020 16:08
 */
public class NumObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {    //有被观察者发生变化，自动调用对应观察者的update方法
        NumObservable observable = (NumObservable) o;     //获取被观察者对象
        System.out.println("Data has changed to " + observable.data);
    }
}
