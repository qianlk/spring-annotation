package org.example.domain;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Qianlk
 */
public class Userinfo implements Serializable {
    private Integer id;
    private byte[] images;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", images=" + Arrays.toString(images) +
                ", description='" + description + '\'' +
                '}';
    }
}
