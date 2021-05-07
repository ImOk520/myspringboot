package GOF.bridge;

import cn.hutool.core.lang.Console;

public class Sun implements HeaterType {
    @Override
    public boolean getHeat() {
        Console.log("太阳能加热！");
        return true;
    }
}
