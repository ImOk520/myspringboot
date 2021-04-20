package GOF.observer.demo2;

/**
 * Feng, Ge 2021/4/20 0020 15:48
 */
public class Client2 {

    public static void main(String[] args) {
        //老板为通知者
        BossSubject boss = new BossSubject();

        StockObserver observer = new StockObserver("adam", boss);
        NBAObserver observer2 = new NBAObserver("tom", boss);

        //老板通知
        boss.attach(observer);
        boss.attach(observer2);

        //tom没被老板通知到，所以不用挨骂
        boss.detach(observer2);

        //老板回来了
        boss.setAction("咳咳，我大Boss回来了！");
        //发通知
        boss.notifyObservers();
    }

}