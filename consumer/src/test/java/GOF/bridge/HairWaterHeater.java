package GOF.bridge;

import cn.hutool.core.lang.Console;


public class HairWaterHeater extends WaterHeater {

    public HairWaterHeater(HeaterType heaterType) {
        super(heaterType);
    }

    @Override
    public void heat() {
        Console.log("海尔热水器准备加热");
        Boolean heat = heaterType.getHeat();
        if (heat) {
            Console.log("海尔热水器开始加热");
        }
        Console.log("加热完毕");
    }
}
