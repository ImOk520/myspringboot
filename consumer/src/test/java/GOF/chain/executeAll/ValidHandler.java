package GOF.chain.executeAll;

import java.util.List;

/**
 * 责任链模式
 */
public interface ValidHandler {
    List<Object> verify(List<Object> allObjectList);
}
