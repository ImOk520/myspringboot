package GOF.chain.executeAll;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链类
 */
public class ValidHandlerChain {
    List<ValidHandler> handlerList = new ArrayList<>();

    public void addHandlers(List<ValidHandler> handlers){
        handlerList.addAll(handlers);
    }

    public void handle(){
        handlerList.forEach(h->{
            h.verify(new ArrayList<>());
        });
    }
}
