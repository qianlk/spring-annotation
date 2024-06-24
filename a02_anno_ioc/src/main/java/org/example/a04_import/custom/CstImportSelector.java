package org.example.a04_import.custom;

import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * 自定义类型 import 扫描器
 * 实现 ImportSelector
 * @author qlk
 */
public class CstImportSelector implements ImportSelector {

    // aspectj 表达式, 指定包下满足表达式的类
    private String expression;

    // 指定扫描包,当@ComponentScan没有指定时扫描
    private String cstPackage;

    /**
     * 默认构造函数,
     * 用于读取配置文件,给表达式赋值
     */
    public CstImportSelector() {
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("cstimport.properties");
            expression = properties.getProperty("cst.importselect.expression");
            cstPackage = properties.getProperty("cst.importselect.package");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 实现获取要导入类的字节码
     * 需求:
     *      导入规则, 使用 AspectJ 表达式找到要导入的文件
     *      <p/>
     *      有@ComponentScan修饰的,直接取包名
     *      有@ComponentScan,但是没有指定包的,就去取@Import注解中的包
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 1.定义扫描包的名称
        List<String> basePackages = null;
        // 2. 判断@Import注解的类上是有还有@ComponentScan, !! 有就优先去扫对应的包
        if (importingClassMetadata.hasAnnotation(ComponentScan.class.getName())) {
            // 3. 取该注解的属性
            Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
            // 4.取出属性名称为basePackages属性的值
            basePackages  = new ArrayList<>(Arrays.asList((String[]) attributes.get("basePackages")));
        }
        // 5.判断注解属性值,如果不满足条件,取@Import的信息
        // 5.1 没有@ComponentScan,则属性值为null
        // 5.2 如果只有@ComponentScan,而没有指定basePackages
        if (basePackages == null || basePackages.size() == 0) {
            String basePackage = null;
            // 6. 取包含@Import的包名 !! org.example.a04_import.config
            try {
                basePackage = Class.forName(importingClassMetadata.getClassName()).getPackage().getName();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // 7. 取完存入 basePackages
            basePackages = new ArrayList<>();
            basePackages.add(basePackage);
        }

        // 判断 cstimport.properties 中是否配置了自定义的扫描包 !! org.example.a04_import.service
        if (!StringUtils.isEmpty(cstPackage)) {
            basePackages.add(cstPackage);
        }


        // 8. 创建类路径扫描器
        // 参数为false, 表示不按照注解方式扫描(默认是按照注解方式)
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        // 9. 创建类型过滤器 (使用切入点表达式类型过滤器)
        TypeFilter typeFilter =
                new AspectJTypeFilter(expression, CstImportSelector.class.getClassLoader());
        // 10. 给扫描器加入类型过滤器
        scanner.addIncludeFilter(typeFilter);
        // 11. 创建存放全限定类名的集合
        Set<String> classes = new HashSet<>();
        // 12.填充该集合
        for (String basePackage : basePackages) {
            scanner.findCandidateComponents(basePackage).forEach(beanDefinition -> {
                classes.add(beanDefinition.getBeanClassName());
            });
        }
        // 13. 返回集合
        return classes.toArray(new String[classes.size()]);
    }
}
