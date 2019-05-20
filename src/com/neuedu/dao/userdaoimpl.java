package com.neuedu.dao;

import com.neuedu.entity.Account;

import java.sql.*;


public class userdaoimpl implements userdao {

    static
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String URL ="jdbc:mysql://localhost:3306/user";
    private  static final String USERNAME = "root";
    private  static final  String PASSWORD = "123456";

    //注册
    @Override
    public void register(String user, String psw)  {
        Connection connection= null;
        PreparedStatement ps = null;
        try
        {
            String sql = "INSERT INTO account(username,password) value(?,?) ";
             connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             ps =  connection.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,psw);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != ps)
            {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //登录
    @Override
    public Account login(Account account) {
         String sql = "SELECT username,password FROM  account  WHERE username = ? AND password = ?";
        try
        {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps =  connection.prepareStatement(sql);
            ps.setString(1,account.getUsername());
            ps.setString(2,account.getPassword());
            ResultSet resultSet =  ps.executeQuery();
            if (resultSet.next())
            {
                return  account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //修改密码
    @Override
    public void Updatepsw(Account account) {
        String sql = " update account set password  = ? where username = ?";
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getPassword());
            preparedStatement.setString(2,account.getUsername());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
