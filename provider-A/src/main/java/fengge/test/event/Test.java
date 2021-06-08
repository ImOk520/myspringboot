package fengge.test.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EventConfig.class);
        context.refresh();
        MyEvent myEvent = new MyEvent(context, "呼叫土豆,呼叫土豆!");
        context.publishEvent(myEvent);
    }
}
