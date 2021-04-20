package GOF.observer.demo2;

/**
 * Feng, Ge 2021/4/20 0020 15:44
 */
public class Client {

    public static void main(String[] args) {
        //前台为通知者
        StaffSubject staffSubject = new StaffSubject();

        StockObserver observer = new StockObserver("adam", staffSubject);
        NBAObserver observer2 = new NBAObserver("tom", staffSubject);

        //前台通知
        staffSubject.attach(observer);
        staffSubject.attach(observer2);

        //adam没被前台通知到，所以被老板抓了个现行
        staffSubject.detach(observer);

        //老板回来了
        staffSubject.setAction("小心！Boss回来了！");
        //发通知
        staffSubject.notifyObservers();
    }

}
