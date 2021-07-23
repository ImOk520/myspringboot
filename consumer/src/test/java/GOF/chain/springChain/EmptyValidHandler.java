package GOF.chain.springChain;

import cn.hutool.core.lang.Console;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 责任链模式
 */
@Component
public class EmptyValidHandler implements ValidHandler {
    @Override
    public List<Object> verify(List<Object> allObjectList) {
        Console.log("非空验证处理");
        Console.log("模拟检验非空过程");
        return allObjectList;
    }
}
