package org.example.a02_componentscan.cst;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.beans.Introspector;
import java.util.Map;
import java.util.Set;

/**
 * 自定义bean name的生成规则
 * 给ComponentScan用
 * @author qlk
 */
public class CstBeanNameGenerator implements BeanNameGenerator {

    private static final String COMPONENT_ANNOTATION_CLASSNAME = "org.springframework.stereotype.Component";

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        // 定义beanName
        String beanName = null;

        // 1. 判断当前bean的定义信息是否来自于注解
        if (definition instanceof AnnotatedBeanDefinition) {
            // 2. 转 BeanDefinition
            AnnotatedBeanDefinition abd = (AnnotatedBeanDefinition) definition;
            // 3. 获取注解bean定义的元信息
            AnnotationMetadata amd = abd.getMetadata();
            // 4. 获取有哪些注解信息
            Set<String> types = amd.getAnnotationTypes();
            for (String type : types) {
                // 5. 得到注解的属性
                AnnotationAttributes attributes =
                        AnnotationAttributes.fromMap(amd.getAnnotationAttributes(type, false));
                // 6.判断attributes是否为null, 同时必须是 @Component及其衍生注解
                if (attributes != null && isStereotypeWithNameValue(type, amd.getMetaAnnotationTypes(type), attributes)) {
                    // 7. 获取注解属性value
                    Object value = attributes.get("value");
                    if (value instanceof String) {
                        String strVal = (String) value;
                        if (StringUtils.hasLength(strVal)) {
                            if (beanName != null && !strVal.equals(beanName)) {
                                throw new IllegalStateException("Stereotype annotations suggest inconsistent " +
                                        "component names: '" + beanName + "' versus '" + strVal + "'");
                            }
                            beanName = strVal;
                        }
                    }
                }
            }
        }
        return beanName != null ? "my" + beanName : "my" + buildDefaultBeanName(definition);
    }

    private boolean isStereotypeWithNameValue(String annotationType,
                                      Set<String> metaAnnotationTypes, @Nullable Map<String, Object> attributes) {

        boolean isStereotype = annotationType.equals(COMPONENT_ANNOTATION_CLASSNAME) ||
                metaAnnotationTypes.contains(COMPONENT_ANNOTATION_CLASSNAME) ||
                annotationType.equals("javax.annotation.ManagedBean") ||
                annotationType.equals("javax.inject.Named");

        return (isStereotype && attributes != null && attributes.containsKey("value"));
    }

    private String buildDefaultBeanName(BeanDefinition definition) {
        String beanClassName = definition.getBeanClassName();
        Assert.state(beanClassName != null, "No bean class name set");
        String shortClassName = ClassUtils.getShortName(beanClassName);
        return Introspector.decapitalize(shortClassName);
    }
}
