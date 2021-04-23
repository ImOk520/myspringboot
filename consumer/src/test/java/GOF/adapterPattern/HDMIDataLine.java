package GOF.adapterPattern;

import cn.hutool.core.lang.Console;

/**
 * HDMI接口实现类——HDMI数据线
 */
public class HDMIDataLine implements HDMIInterface{

    @Override
    public void showWithHDMI() {
        Console.log("我是HDMI高清数据线，是我在传输数据...");
    }
}
