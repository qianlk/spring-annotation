package org.example.jdbc.handler.impl;

import org.example.jdbc.handler.ResultSetHandler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * 封装到实体类中的结果集处理器
 *
 * @author Qianlk
 */
public class BeanHandler<T> implements ResultSetHandler {

    // 定义封装的类
    private Class<T> requiredType;

    public BeanHandler(Class requiredType) {
        this.requiredType = requiredType;
    }

    @Override
    public Object handle(ResultSet rs) {
        T bean = null;
        try {
            // 1.判断是否有结果集
            if (rs.next()) {
                // 2.实例化返回值对象
                bean = requiredType.newInstance();
                // 3,获取结果集的元信息
                ResultSetMetaData rsmd = rs.getMetaData();
                // 4.获取结果集的列数
                int columnCount = rsmd.getColumnCount();
                // 5.遍历列数
                for (int i = 0; i < columnCount; i++) {
                    // 取出列标题
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    // 取出列对应的数据
                    Object value = rs.getObject(columnLabel);
                    // 借助java的内省机制,使用属性描述器进行填充
                    PropertyDescriptor pd = new PropertyDescriptor(columnLabel, requiredType);
                    Method writeMethod = pd.getWriteMethod();
                    writeMethod.invoke(bean, value);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return bean;
    }
}
