package GOF.chain.stop;

import cn.hutool.core.lang.Console;

import java.util.List;

/**
 * Feng, Ge 2021/7/23 0023 9:56
 */
public class LengthValidHandler implements ValidHandler {
    @Override
    public boolean verify(List<Object> allObjectList) {
        Console.log("长度验证处理");
        Console.log("模拟检验长度过程");
        return false;
    }
}
