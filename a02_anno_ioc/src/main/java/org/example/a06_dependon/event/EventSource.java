package org.example.a06_dependon.event;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @author qlk
 */
@Component
@DependsOn("eventListener")
public class EventSource {

    public EventSource() {
        System.out.println("事件源对象创建");
    }
}
