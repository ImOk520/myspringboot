package GOF.template;

/**
 * 子类：炒藕带
 */
public class Lotus extends Cooking{

    @Override
    protected void startFry() {
        System.out.println("开始炒藕带");
    }

    @Override
    protected void addCondiments() {
        System.out.println("放醋");
    }
}