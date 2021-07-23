package GOF.chain.stop;

import cn.hutool.core.lang.Console;

import java.util.List;

/**
 * 责任链模式
 */
public class RangeValidHandler implements ValidHandler {
    @Override
    public boolean verify(List<Object> allObjectList) {
        Console.log("范围验证处理");
        Console.log("模拟检验范围过程");
        return true;
    }
}
