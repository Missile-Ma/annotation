package com.missile.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author Missile
 * @Date 2021-02-02-20:44
 */
public class MyTypeFilter implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //获取当前类资源（类的路径）
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("classname------>"+className);

        if (className.contains("er")){
            return true;
        }
        return false;
    }
    /*
    确定此过滤器是否与以下描述的类匹配
    给定的元数据。
    @param metadataReader目标类的元数据阅读器:正在扫描的类的信息
    @param metadataReaderFactory用于获取元数据阅读器的工厂:可以获取到其他任何类信息的工厂
    用于其他类（例如超类和接口）
    @return此过滤器是否匹配
    在读取元数据时I / O失败的情况下@throws IOException
     */
}
