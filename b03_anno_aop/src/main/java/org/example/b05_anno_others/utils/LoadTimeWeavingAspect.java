package org.example.b05_anno_others.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * https://www.bilibili.com/video/BV1hE411o7w7/?p=88
 * 启用类加载时织入
 * @author Qianlk
 */
@Component
@Aspect
public class LoadTimeWeavingAspect {

    @Around("execution(* org.example.b05_anno_others.service.impl.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch sw = new StopWatch(this.getClass().getSimpleName());
        try {
            sw.start(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            sw.stop();
            System.out.println(sw.prettyPrint());
        }
    }
}
