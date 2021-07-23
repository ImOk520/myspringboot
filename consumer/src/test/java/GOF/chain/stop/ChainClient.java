package GOF.chain.stop;

import cn.hutool.core.lang.Console;
import org.assertj.core.util.Lists;

/**
 * Feng, Ge 2021/7/23 0023 10:18
 */
public class ChainClient {
    public static void main(String[] args) {
        ValidHandlerChain chain = new ValidHandlerChain();
        chain.addHandlers(Lists.newArrayList(new EmptyValidHandler(), new LengthValidHandler(), new RangeValidHandler()));
        boolean flag = chain.handle();
        if(!flag){
            Console.log("中间有处理器处理错误，中断责任链流程");
        }
    }
}
