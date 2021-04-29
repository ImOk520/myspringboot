package GOF.flyweight;

public class Client {
    public static void main(String[] args) {
        PotFactory potFactory = new PotFactory();

        Pot pot01 = potFactory.getPot("平底锅");
        pot01.cooking();

        Pot pot02 = potFactory.getPot("高压锅");
        pot02.cooking();
    }
}
