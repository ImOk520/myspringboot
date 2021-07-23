package GOF.chain.stop;

import java.util.List;

/**
 * 责任链模式
 */
public interface ValidHandler {
    boolean verify(List<Object> allObjectList);
}
