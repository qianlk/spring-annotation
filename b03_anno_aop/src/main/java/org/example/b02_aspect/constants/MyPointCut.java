package org.example.b02_aspect.constants;

import org.aspectj.lang.annotation.Pointcut;
import org.example.b02_aspect.domain.User;

/**
 * @author qlk
 */
public class MyPointCut {

    @Pointcut(value = "execution(* org.example.b02_aspect.service.impl.*.*(..)) && args(user)")
    public void pointcut(User user) {

    }
}
