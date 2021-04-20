package GOF.observer.demo3;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者，相当于
 * Feng, Ge 2021/4/20 0020 15:52
 */
public class ProductList extends Observable {
    // 产品列表
    private List<String> productList = null;
    // 单例模式，唯一实例
    private static ProductList instance;

    private ProductList() {}

    // 获取唯一实例
    public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
            instance.productList = new ArrayList<>();
        }
        return instance;
    }

    // 电商入驻（新增观察者）
    public void addObservers(Observer observer){
        // 这里的addObserver（）方法是继承于Observable类
        this.addObserver(observer);
    }

    // 新增产品
    public void addProduct(String newProduct){
        productList.add(newProduct);
        System.out.println("【产品列表更新】新增" + newProduct + "产品！");
        // 设置被观察者状态变化
        this.setChanged();
        // 通知观察者
        this.notifyObservers(newProduct);
    }
}