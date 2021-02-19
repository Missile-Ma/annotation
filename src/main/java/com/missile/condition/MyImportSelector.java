package com.missile.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Missile
 * @Date 2021-02-03-22:16
 */
public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.missile.bean.Blue","com.missile.bean.Red","com.missile.bean.Yellow","com.missile.bean.Green"};

    }
}
