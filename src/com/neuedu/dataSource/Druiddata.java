package com.neuedu.dataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class Druiddata {
    private Druiddata()
    {

    }
    private static Druiddata da;

    private  static Properties prop = new Properties();
    public static Druiddata getDruidata()
    {
        if (null == da)
        {
            da = new Druiddata();
        }
        return da;
    }
    public Connection getconnection()
    {
        try {
            prop.load(Druiddata.class.getResourceAsStream("/mysql.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {

        }
        return null;
    }
}
