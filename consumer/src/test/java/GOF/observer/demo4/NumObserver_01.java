package GOF.observer.demo4;

import cn.hutool.core.lang.Console;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者2
 * Feng, Ge 2021/4/20 0020 16:26
 */
public class NumObserver_01 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        NumObservable observable = (NumObservable) o;
        Console.log("观察者2——Data has changed to " + observable.data);
    }
}
