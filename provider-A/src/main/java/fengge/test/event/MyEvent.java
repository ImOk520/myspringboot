package fengge.test.event;

import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * Feng, Ge 2021/6/8 0008 11:17
 */
@ToString
public class MyEvent extends ApplicationEvent {

    private String message;

    public MyEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
