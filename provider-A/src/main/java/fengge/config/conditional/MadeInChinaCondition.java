package fengge.config.conditional;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ArrayUtil;
import fengge.DTO.CarDTO;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 实现Condition是个接口中的matches方法，返回true则注入bean，false则不注入。
 */
public class MadeInChinaCondition implements Condition {

    /**
     * AnnotatedTypeMetadata:注解所在位置的注释信息
     * ConditionContext:判断条件能使用的上下文环境
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String[] beanNamesForType = context.getBeanFactory().getBeanNamesForType(CarDTO.class);
        if (!ArrayUtil.contains(beanNamesForType, "BMW")) {
            return true;
        }
        return false;
    }
}
