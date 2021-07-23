package GOF.chain.stop;

import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链类
 */
public class ValidHandlerChain {
    List<ValidHandler> handlerList = new ArrayList<>();

    public void addHandlers(List<ValidHandler> handlers) {
        handlerList.addAll(handlers);
    }

    public boolean handle() {
        boolean flag = true;
        for (ValidHandler handler : handlerList) {
            boolean isSuccess = handler.verify(new ArrayList<>());
            if (!isSuccess) {
                flag = isSuccess;
                break;
            }
        }
        return flag;
    }
}
