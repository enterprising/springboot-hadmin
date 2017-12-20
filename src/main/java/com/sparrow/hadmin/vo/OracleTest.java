package com.sparrow.hadmin.vo;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.Properties;

/**
 * Created by peng.tan on 17/12/20.
 */
public class OracleTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Driver driver = new OracleDriver();
        DriverManager.deregisterDriver(driver);

        Properties pro = new Properties();
        pro.put("user", "system");
        pro.put("password", "oracle");
        Connection connect = driver.connect("jdbc:oracle:thin:@127.0.0.1:49161:xe", pro);

        //测试connect正确与否
        System.out.println(connect);

        // 获取 PreparedStatement 对象
        PreparedStatement preState = connect.prepareStatement("SELECT * FROM \"test\"");

        // 执行SQL语句
        ResultSet resultSet = preState.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
        }

    }

}