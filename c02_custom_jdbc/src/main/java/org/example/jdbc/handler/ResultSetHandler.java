package org.example.jdbc.handler;

import java.sql.ResultSet;

/**
 * 结果集处理器
 *
 * @author Qianlk
 */
public interface ResultSetHandler {

    Object handle(ResultSet rs);
}
