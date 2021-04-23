package GOF.adapterPattern;

import cn.hutool.core.lang.Console;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 老式显示器类，只支持 VGA 接口信号输入
 */
@NoArgsConstructor
@Setter
@Getter
public class OldMonitor {

    private VGAInterface vgaInterface;

    public OldMonitor(VGAInterface vgaInterface) {
        this.vgaInterface = vgaInterface;
    }

    public void show() {
        Console.log("准备好接收VGA信号...");
        vgaInterface.showWithVGA();
        Console.log("接收完毕，展示中...");
    }
}
