package org.example.a04_import.custom;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * 自定义 实现ImportBeanDefinitionRegistrar
 * bean定义注册器
 *
 * @author qlk
 */
public class CstImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    // 自定义扫描类的表达式
    private String expression;

    // 之定义扫描包
    private String cstPackage;

    public CstImportBeanDefinitionRegistrar() {
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("cstimport.properties");
            expression = properties.getProperty("cst.importselect.expression");
            cstPackage = properties.getProperty("cst.importselect.package");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 实现注册bean的功能（它是通过扫描指定包实现的）
     * @param importingClassMetadata annotation metadata of the importing class
     * @param registry current bean definition registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 1. 定义扫描包集合
        List<String> basePackages = null;
        // 2. 判断是否包含@ComponentScan注解
        if (importingClassMetadata.hasAnnotation(ComponentScan.class.getName())) {
            // 3. 取出注解属性
            Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
            // 4. 取出注解属性中的 basePackages 或者 value
            basePackages = new ArrayList<>(Arrays.asList((String[]) attributes.get("basePackages")));
        }

        // 5. 如果@componnetScan没有或者没有指定扫描包, basePackages为null或者size=0
        if (basePackages == null || basePackages.size() == 0) {
            // 6. 取出 @Import注解类所在的包
            String basePackage = null;
            try {
                basePackage = Class.forName(importingClassMetadata.getClassName()).getPackage().getName();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            // 7. 添加在扫描包的集合中
            basePackages = new ArrayList<>();
            basePackages.add(basePackage);
        }

        // 判断用户是否配置了扫描包
        if (!StringUtils.isEmpty(cstPackage)) {
            basePackages.add(cstPackage);
        }

        // 8. 创建类路径bean定义扫描器
        // ClassPathBeanDefinitionScanner vs ClassPathScanningCandidateComponentProvider
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry, false);
        // 9. 创建类型过滤器
        TypeFilter typeFilter = new AspectJTypeFilter(expression, CstImportBeanDefinitionRegistrar.class.getClassLoader());
        // 10. 添加类型过滤器到扫描器中
        scanner.addIncludeFilter(typeFilter);
        // 11. 扫描指定的包
        scanner.scan(basePackages.toArray(new String[basePackages.size()]));
    }
}
