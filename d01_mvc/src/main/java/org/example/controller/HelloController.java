package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Qianlk
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("控制器方法执行了");
        return "success";
    }
}
