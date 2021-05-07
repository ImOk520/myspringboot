package GOF.bridge;

import cn.hutool.core.lang.Console;

public class Gas implements HeaterType {
    @Override
    public boolean getHeat() {
        Console.log("燃气加热！");
        return true;
    }
}
