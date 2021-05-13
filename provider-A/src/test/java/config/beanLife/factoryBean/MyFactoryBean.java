package config.beanLife.factoryBean;

import cn.hutool.core.lang.Console;
import fengge.DTO.CarDTO;
import org.springframework.beans.factory.FactoryBean;

/**
 * 使用FactoryBean实现组件注册到容器
 */
public class MyFactoryBean implements FactoryBean<CarDTO> {

    /**
     * 这里的CartDTO类型的bean组件，会注入spring容器
     */
    @Override
    public CarDTO getObject() throws Exception {
        Console.log("MyFactoryBean中的getObject()方法生成carDTO这个bean");
        return new CarDTO(666, "BMW");
    }

    /**
     * 这里返回要注入的bean的Class对象
     */
    @Override
    public Class<?> getObjectType() {
        return CarDTO.class;
    }

    /**
     *  设置是否是单例
     *  1、如果是true容器中只保留一个bean对象
     *  2、若是false每次获取则产生新的bean对象
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
