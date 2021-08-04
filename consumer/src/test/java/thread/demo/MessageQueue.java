package thread.demo;

import java.util.LinkedList;

/**
 * 消息队列，Java线程之间通信
 */
public class MessageQueue {

    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(2);

        //测试
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                queue.put(new Message(id, "值" + id));
            }, "生产者" + i).start();
        }

        new Thread(() -> {
            queue.take();
        }, "消费者").start();
    }

    private LinkedList<Message> list = new LinkedList<>();
    private int capcity;

    public MessageQueue(int capcity) {
        this.capcity = capcity;
    }

    //获取消息
    public Message take() {
        //检查对象是否为空
        synchronized (list) {
            while (list.isEmpty()) {
                try {
                    System.out.println("对列为空，消费者线程只能等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //从队列头部获取消息并返回
            Message message = list.removeFirst();
            System.out.println("已消费消息： " +message);
            list.notifyAll();

            return message;
        }
    }

    //存入消息
    public void put(Message message) {
        synchronized (list) {
            //检查队列是否已满
            while (list.size() == capcity) {
                try {
                    System.out.println("队列已满，生产者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(message);
            System.out.println("已生产消息： " + message);
            list.notifyAll();
        }
    }

}

final class Message {
    private int id;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }

    private Object value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}