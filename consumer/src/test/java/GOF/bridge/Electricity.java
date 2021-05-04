package GOF.bridge;

import cn.hutool.core.lang.Console;

public class Electricity implements HeaterType {
    @Override
    public boolean getHeat() {
        Console.log("电加热！");
        return true;
    }
}
