package GOF.template;

public class Eggplant extends Cooking{

    @Override
    protected void startFry() {
        System.out.println("开始炒茄子");
    }

    @Override
    protected void addCondiments() {
        System.out.println("放盐");
    }
}