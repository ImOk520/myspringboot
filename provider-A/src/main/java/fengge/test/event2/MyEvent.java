package fengge.test.event2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MyEvent extends ApplicationEvent {

    private Goods goods;

    public MyEvent(Object source, Goods goods) {
        super(source);
        this.goods = goods;
    }
}
