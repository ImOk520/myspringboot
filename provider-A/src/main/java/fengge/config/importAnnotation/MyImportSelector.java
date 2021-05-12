package fengge.config.importAnnotation;

import cn.hutool.core.lang.Console;
import org.bouncycastle.util.Selector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 *
 */
public class MyImportSelector implements ImportSelector {

    /**
     * 方法返回值就是要导入的组件全类名数组
     * AnnotationMetadata ：@import注解所在类的所有注解信息
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Console.log("@import注解所在类的所有注解类型信息:" + importingClassMetadata.getAnnotationTypes());
        return new String[]{"fengge.config.importAnnotation.C", "fengge.config.importAnnotation.D"};
    }
}
