package fengge.config.componentScan;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * Feng, Ge 2021/5/7 0007 16:43
 */
public class MyFilterType implements TypeFilter {

    /**
     * MetadataReader 读取到当前正在扫描类的信息
     * MetadataReaderFactory 可以获取到其他任何类信息
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源（类的路径）
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("===============>" + className);
        if (className.contains("Co")) {
            return true;
        }
        return false;
    }
}
