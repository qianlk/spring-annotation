package org.example.a08_conditional.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author qlk
 */
public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 3. 获取环境信息
        Environment envs = context.getEnvironment();
        // 5. 获取os
        String osName = envs.getProperty("os.name");
//        osName = "os.Linux";
        // 6. 根据包含Windows,选择是否注入到容器中
        if (osName.contains("Linux")) {
            return true;
        }
        return false;
    }
}
