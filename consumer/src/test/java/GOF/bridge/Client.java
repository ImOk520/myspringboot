package GOF.bridge;

import cn.hutool.core.lang.Console;

public class Client {
    public static void main(String[] args) {
        // 如果选择的是海尔燃气热水器
        WaterHeater hairWaterHeater = new HairWaterHeater(new Gas());
        hairWaterHeater.heat();

        Console.log("=============================================");

        // 如果选择的是格力太阳能热水器
        WaterHeater geliWaterHeater = new GeliWaterHeater(new Sun());
        geliWaterHeater.heat();
    }
}
