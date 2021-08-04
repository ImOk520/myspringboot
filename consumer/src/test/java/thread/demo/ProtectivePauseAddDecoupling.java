package thread.demo;

/**
 * 同步模式之保护性暂停
 * 扩展： 解耦
 */
public class ProtectivePauseAddDecoupling {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new People().start();
        }
        Thread.sleep(1);

        for (Integer id : Mailboxes.getIds()) {
            new Postman(id, "居民id为： " + id +"的内容").start();
        }
    }
}
