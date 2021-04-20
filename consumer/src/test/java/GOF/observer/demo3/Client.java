package GOF.observer.demo3;

/**
 * Feng, Ge 2021/4/20 0020 15:57
 */
public class Client {
    public static void main(String[] args) {
        ProductList productList = ProductList.getInstance();
        Taobao taobaoObserver = new Taobao();
        Jingdong jingDongObserver = new Jingdong();
        productList.addObservers(taobaoObserver);
        productList.addObservers(jingDongObserver);
        productList.addProduct("面膜");
    }
}
