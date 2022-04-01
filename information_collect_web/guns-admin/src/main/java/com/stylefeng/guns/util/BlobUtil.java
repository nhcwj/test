package com.stylefeng.guns.util;


import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.*;
import java.sql.*;

public class BlobUtil extends BaseTypeHandler<InputStream> {
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    String parameter, JdbcType jdbcType) throws SQLException {
        //声明一个输入流对象
        ByteArrayInputStream bis;
        try {
            //把字符串转为字节流
            bis = new ByteArrayInputStream(parameter.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Blob Encoding Error!");
        }
        ps.setBinaryStream(i, bis, parameter.length());
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, InputStream inputStream, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public InputStream getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        Blob blob = (Blob) rs.getBlob(columnName);
        if(blob==null){
            return null;
        }
        InputStream fis = blob.getBinaryStream();

        return fis;
    }
    @Override
    public InputStream getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public InputStream getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }


}