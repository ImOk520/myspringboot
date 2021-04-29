package GOF.flyweight;

import cn.hutool.core.lang.Console;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConcretePot extends Pot {
    private String type;

    @Override
    public void cooking() {
        Console.log("使用" + type + "做饭。");
    }
}
