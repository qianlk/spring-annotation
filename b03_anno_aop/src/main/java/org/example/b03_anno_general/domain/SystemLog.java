package org.example.b03_anno_general.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 系统日志
 *
 * @author Qianlk
 */
public class SystemLog implements Serializable {
    private String id;
    private String method;
    private String action;
    private LocalDateTime time;
    private String remoteIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    @Override
    public String toString() {
        return "SystemLog{" +
                "id='" + id + '\'' +
                ", method='" + method + '\'' +
                ", action='" + action + '\'' +
                ", time=" + time +
                ", remoteIp='" + remoteIp + '\'' +
                '}';
    }
}
