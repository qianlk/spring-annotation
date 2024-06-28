package org.example.b04_anno_around.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.b03_anno_general.domain.SystemLog;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

/**
 * 记录日志的工具类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
@Aspect  // 表明当前类是一个切面类
public class LogUtil {

    @Around("execution(* org.example.b04_anno_around.service.impl.*.*(..))")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rt  = null;
        try {
            // 创建系统日志
            SystemLog log = new SystemLog();
            String id = UUID.randomUUID().toString().replace("-", "").toUpperCase();
            log.setId(id);
            log.setRemoteIp("127.0.0.1");
            log.setTime(LocalDateTime.now());
            // 获取当前执行的方法
            Signature signature = pjp.getSignature();  // 方法前面
            if (signature instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) signature;
                Method method = methodSignature.getMethod();
                String methodName = method.getName();
                log.setMethod(methodName);

                // 设置方法说明  @Description
                // 判断是否存在注解
                boolean present = method.isAnnotationPresent(Description.class);
                if (present) {
                    // 获取注解值
                    Description description = method.getAnnotation(Description.class);
                    String value = description.value();
                    log.setAction(value);
                }
            }

            System.out.println("环绕通知执行方法日志: " + log);


            // args 可写可不写,
            // 但要注意目标方法如果有返回值,此通知方法最好要是Object
            Object[] args = pjp.getArgs();
            rt = pjp.proceed(args);
            return rt;
        } catch (Throwable e) {
            System.out.println("异常通知");
            throw new RuntimeException(e);
        }
    }

}
