package GOF.observer.demo2;

/**
 * Feng, Ge 2021/4/20 0020 15:29
 */
public interface Subject {

    //增加
    public void attach(Observer observer);
    //删除
    public void detach(Observer observer);
    //通知
    public void notifyObservers();

    //状态
    public void setAction(String action);
    public String getAction();

}