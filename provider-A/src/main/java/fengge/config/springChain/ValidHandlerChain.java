package fengge.config.springChain;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 责任链类
 */
@Component
public class ValidHandlerChain implements InitializingBean{

    @Autowired
    private ApplicationContext applicationContext;

    private final List<ValidHandler> validHandlerList = new ArrayList<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, ValidHandler> handlers = applicationContext.getBeansOfType(ValidHandler.class);
        handlers.forEach((key,value) -> validHandlerList.add(value));
    }

    public List<Object> handle(List<Object> objectList) {
        List<Object> result = null;
        for (ValidHandler handler : validHandlerList) {
            result = handler.verify(objectList);
            if(CollectionUtils.isEmpty(result)){
                return result;
            }
        }
        return result;
    }

}
