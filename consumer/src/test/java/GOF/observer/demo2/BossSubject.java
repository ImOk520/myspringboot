package GOF.observer.demo2;

import java.util.LinkedList;
import java.util.List;

/**
 * Feng, Ge 2021/4/20 0020 15:41
 */
public class BossSubject implements Subject{
    //同事列表
    private List<Observer> observers = new LinkedList<>();
    private String action;

    //添加
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    //删除
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    //通知
    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }

    //前台状态
    @Override
    public String getAction() {
        return action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }
}
