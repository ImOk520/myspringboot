package fengge.config.importAnnotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyRegistry implements ImportBeanDefinitionRegistrar {

    /**
     * 手动将需要的bean定义注册
     * AnnotationMetadata ：@import注解所在类的所有注解信息
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(E.class);
        registry.registerBeanDefinition("E", rootBeanDefinition);
    }
}
