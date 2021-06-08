package fengge.test.event;

import cn.hutool.core.lang.Console;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Feng, Ge 2021/6/8 0008 11:17
 */
public class MyListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        Console.log("事件信息：{}", event);
    }
}
