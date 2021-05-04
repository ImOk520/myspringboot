package GOF.interpreter;

import java.util.Map;

public class Context {
    private Map<String, Expression> map;

    public String getValue(String key){
        return map.get(key).interpret(this);
    }
}
