package GOF.chain.executeAll;

import org.assertj.core.util.Lists;

/**
 * Feng, Ge 2021/7/23 0023 10:18
 */
public class ChainClient {
    public static void main(String[] args) {
        ValidHandlerChain chain = new ValidHandlerChain();
        chain.addHandlers(Lists.newArrayList(new EmptyValidHandler(), new LengthValidHandler(), new RangeValidHandler()));
        chain.handle();
    }
}
