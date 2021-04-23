package GOF.adapterPattern;

import lombok.AllArgsConstructor;

/**
 * Feng, Ge 2021/4/23 0023 17:12
 */
@AllArgsConstructor
public class Adapter implements VGAInterface{

    // 这里没有使用HDMIDataLine作为成员变量，主要是体现依赖倒置原则
    private HDMIInterface hdmiInterface;

    @Override
    public void showWithVGA() {
        hdmiInterface.showWithHDMI();
    }
}
