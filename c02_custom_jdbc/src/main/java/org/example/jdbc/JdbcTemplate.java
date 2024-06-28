package org.example.jdbc;

import org.example.jdbc.handler.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.*;

/**
 * 自定义jdbcTemplate
 *
 * @author Qianlk
 */
public class JdbcTemplate {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcTemplate() {
    }

    public JdbcTemplate(DataSource dataSource) {
        setDataSource(dataSource);
    }

    /**
     * 增删改
     */
    public int update(String sql, Object... params) {
        if (dataSource == null) {
            throw new NullPointerException("DataSource can not be null!!");
        }
        // 1.定义update相关的操作对象
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // 2.获取连接
            conn = dataSource.getConnection();
            // 3.获取预处理对象
            pstm = conn.prepareStatement(sql);
            // 4.获取参数的元信息
            ParameterMetaData pmd = pstm.getParameterMetaData();
            // 5.获取sql语句中参数的个数
            int parameterCount = pmd.getParameterCount();
            // 6.判断sql语句中是否有参数
            if (parameterCount > 0) {
                // 是否提供了参数
                if (params == null) {
                    throw new IllegalArgumentException("Parameter can not be null");
                }
                // 参数个数是否匹配
                if (parameterCount != params.length) {
                    throw new IllegalArgumentException("Incorrect parameter size: expected " + parameterCount + ", actual " + params.length);
                }
                // 占位符赋值
                for (int i = 0; i < parameterCount; i++) {
                    pstm.setObject(i + 1, params[i]);
                }

            }
            // 7.执行sql
            int rt = pstm.executeUpdate();
            return rt;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.release(null, pstm, conn);
        }
    }

    private void release(ResultSet rs, PreparedStatement pstm, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 查询方法
     *
     * @param sql    语句
     * @param rsh    处理结果集的封装,此处只是提供一个规范, 具体的实现由调用者实现
     * @param params 语句的参数
     */
    public Object query(String sql, ResultSetHandler rsh, Object... params) {
        if (dataSource == null) {
            throw new NullPointerException("DataSource can not be null!!");
        }
        // 1.定义update相关的操作对象
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            // 2.获取连接
            conn = dataSource.getConnection();
            // 3.获取预处理对象
            pstm = conn.prepareStatement(sql);
            // 4.获取参数的元信息
            ParameterMetaData pmd = pstm.getParameterMetaData();
            // 5.获取sql语句中参数的个数
            int parameterCount = pmd.getParameterCount();
            // 6.判断sql语句中是否有参数
            if (parameterCount > 0) {
                // 是否提供了参数
                if (params == null) {
                    throw new IllegalArgumentException("Parameter can not be null");
                }
                // 参数个数是否匹配
                if (parameterCount != params.length) {
                    throw new IllegalArgumentException("Incorrect parameter size: expected " + parameterCount + ", actual " + params.length);
                }
                // 占位符赋值
                for (int i = 0; i < parameterCount; i++) {
                    pstm.setObject(i + 1, params[i]);
                }
            }
            // 7.执行sql
            rs = pstm.executeQuery();
            // 8.封装结果集
            return rsh.handle(rs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.release(rs, pstm, conn);
        }
    }
}
