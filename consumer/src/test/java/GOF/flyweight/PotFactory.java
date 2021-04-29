package GOF.flyweight;

import java.util.HashMap;

/**
 * Feng, Ge 2021/4/29 0029 16:10
 */
public class PotFactory {

    private HashMap<String, ConcretePot> pool = new HashMap<>();

    public Pot getPot(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcretePot(type));
        }
        return pool.get(type);
    }
}
