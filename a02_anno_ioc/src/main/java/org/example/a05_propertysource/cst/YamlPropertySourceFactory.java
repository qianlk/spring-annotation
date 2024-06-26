package org.example.a05_propertysource.cst;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * 自定义解析yaml文件的工厂类
 *
 * @author qlk
 * @see org.springframework.core.io.support.PropertySourceFactory
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {

    /**
     * 自定义解析规则
     * @param name the name of the property source
     * @param resource the resource (potentially encoded) to wrap
     * @return
     * @throws IOException
     */
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        // 1. 创建yaml文件解析工厂
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        // 2.设置要解析的资源内容
        factoryBean.setResources(resource.getResource());
        // 3.把资源解析成 properties文件
        Properties properties = factoryBean.getObject();
        // 4.返回propertySource对象
        return (name != null
                ? new PropertiesPropertySource(name, properties)
                : new PropertiesPropertySource(resource.getResource().getFilename(), properties));
    }
}
