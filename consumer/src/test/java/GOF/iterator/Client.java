package GOF.iterator;

/**
 * Feng, Ge 2021/4/26 0026 13:54
 */
public class Client {
    public static void main(String[] args) {
        //创建容器
        Aggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.add("1");
        aggregate.add("2");
        aggregate.add("3");
        aggregate.add("4");

        //拿到容器迭代器，使用迭代器遍历
        Iterator<String> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println("Aggregate: " + iterator.next());
        }
    }
}
