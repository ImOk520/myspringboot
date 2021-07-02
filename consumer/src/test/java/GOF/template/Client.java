package GOF.template;

/**
 * Feng, Ge 2021/7/1 0001 17:00
 */
public class Client {
    public static void main(String[] args) {
        Cooking cookEggplant = new Eggplant();
        Cooking cookLotus = new Lotus();
        cookEggplant.doCooking();
        System.out.println("-----------");
        cookLotus.doCooking();
    }
}
