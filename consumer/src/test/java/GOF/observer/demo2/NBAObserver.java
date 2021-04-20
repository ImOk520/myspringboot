package GOF.observer.demo2;

/**
 * Feng, Ge 2021/4/20 0020 15:42
 */
public class NBAObserver extends Observer {

    public NBAObserver(String name, Subject subject) {
        super(name, subject);
    }

    @Override
    public void update() {
        System.out.println(subject.getAction() + "\n" + name + "关闭股票行情，继续工作");
    }

}
