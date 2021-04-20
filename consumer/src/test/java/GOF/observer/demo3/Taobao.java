package GOF.observer.demo3;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者1
 * Feng, Ge 2021/4/20 0020 15:55
 */
public class Taobao implements Observer {

    @Override
    public void update(Observable o, Object product) {
        String newProduct = (String) product;
        System.out.println("淘宝更新产品： " + newProduct);
    }
}
