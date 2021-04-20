package GOF.observer.demo5;

/**
 * Feng, Ge 2021/4/20 0020 16:54
 */
public class Client {
    public static void main(String[] args) {
        NotOnlyObservableButAlsoObserver_A ooa = new NotOnlyObservableButAlsoObserver_A();
        NotOnlyObservableButAlsoObserver_B oob = new NotOnlyObservableButAlsoObserver_B();

        oob.addObserver(ooa);
        ooa.addObserver(oob);

        oob.setData(1);
    }
}
