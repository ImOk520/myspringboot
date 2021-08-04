package thread.demo;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

class Mailboxes {
    private static Map<Integer, GuardedObject02> boxes = new Hashtable<>();

    private static int id = 1;
    //产生唯一id
    private static synchronized int generateId() {
        return id++;
    }

    public static GuardedObject02 createGuardedObject() {
        GuardedObject02 go = new GuardedObject02(generateId());
        boxes.put(go.getId(), go);
        return go;
    }

    public static Set<Integer> getIds() {
        return boxes.keySet();
    }

    public static GuardedObject02 getGuardObject(int id) {
        return boxes.remove(id);
    }

}
