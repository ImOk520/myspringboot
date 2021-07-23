package fengge.config.springChain;

import cn.hutool.core.lang.Console;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 责任链模式
 */
@Component
public class RangeValidHandler implements ValidHandler {
    @Override
    public List<Object> verify(List<Object> allObjectList) {
        Console.log("范围验证处理");
        Console.log("模拟检验范围过程");
        return allObjectList;
    }
}
