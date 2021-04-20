package GOF.observer.demo3;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者2
 * Feng, Ge 2021/4/20 0020 15:56
 */
public class Jingdong implements Observer {

    @Override
    public void update(Observable o, Object product) {
        String newProduct = (String) product;
        System.out.println("京东更新产品： " + newProduct);
    }
}
