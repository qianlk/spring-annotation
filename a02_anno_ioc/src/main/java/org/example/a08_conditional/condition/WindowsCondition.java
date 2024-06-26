package org.example.a08_conditional.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * 自定义注册bean的条件, windows操作系统时
 *
 * @author qlk
 */
public class WindowsCondition implements Condition {

    /**
     * 是否注册到ioc容器 配合 @Conditional
     * @param context the condition context
     * @param metadata metadata of the {@link org.springframework.core.type.AnnotationMetadata class}
     * or {@link org.springframework.core.type.MethodMetadata method} being checked
     * @return true表示注册
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 1. 获取ioc使用的 BeanFactory 对象
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 2. 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 3. 获取环境信息
        Environment envs = context.getEnvironment();
        // 输出所有的环境变量
        if (envs instanceof StandardEnvironment) {
            StandardEnvironment standardEnvironment = (StandardEnvironment) envs;
            Map<String, Object> map = standardEnvironment.getSystemProperties();
            for (Map.Entry<String, Object> me : map.entrySet()) {
                System.out.println(me.getKey() + "," + me.getValue());
            }
        }
        // 4. 获取bean定义信息的注册器
        BeanDefinitionRegistry registry = context.getRegistry();
        // 5. 获取os
        String osName = envs.getProperty("os.name");
        // 6. 根据包含Windows,选择是否注入到容器中
        if (osName.contains("Windows")) {
            return true;
        }
        return false;
    }
}
