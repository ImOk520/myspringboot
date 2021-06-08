package fengge.test.event2;

import cn.hutool.core.lang.Console;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Feng, Ge 2021/6/8 0008 13:59
 */
@Component
public class MyListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        Goods goods = event.getGoods();
        Console.log("商品信息：{}", goods);
    }
}
