package org.example.a06_dependon.event;

import org.springframework.stereotype.Component;

/**
 * @author qlk
 */
@Component
public class EventListener {

    public EventListener() {
        System.out.println("监听器创建了");
    }
}
