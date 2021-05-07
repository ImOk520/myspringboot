package GOF.bridge;

import cn.hutool.core.lang.Console;


public class GeliWaterHeater extends WaterHeater {

    public GeliWaterHeater(HeaterType heaterType) {
        super(heaterType);
    }

    @Override
    public void heat() {
        Console.log("格力热水器准备加热");
        Boolean heat = heaterType.getHeat();
        if (heat) {
            Console.log("格力热水器开始加热");
        }
        Console.log("加热完毕");
    }
}
