package fengge.test.event;

import cn.hutool.core.lang.Console;
import org.springframework.context.event.EventListener;


public class MyAnnotationListener {

    @EventListener
    public void onApplicationEvent(MyEvent event) {
        Console.log("@EventListener注解监听到的事件信息：{}", event);
    }
}
