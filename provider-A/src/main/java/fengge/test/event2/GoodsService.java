package fengge.test.event2;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Feng, Ge 2021/6/8 0008 14:03
 */
@Service
public class GoodsService {

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 发布事件
     * @return
     */
    public Goods getGoods() {
        Goods goods = new Goods("电视", "6666");
        MyEvent event = new MyEvent(this, goods);
        applicationContext.publishEvent(event);
        return goods;
    }
}
