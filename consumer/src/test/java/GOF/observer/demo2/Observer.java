package GOF.observer.demo2;

/**
 * Feng, Ge 2021/4/20 0020 15:30
 */
public abstract class Observer {

    protected String name;
    protected Subject subject;

    public Observer(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public abstract void update();

}
