package com.neuedu.dao;

import com.neuedu.dataSource.Druiddata;
import com.neuedu.pojo.Product;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class ProDaoimpl implements ProDao{
    private Druiddata druiddata;
    public ProDaoimpl()
    {
        this.druiddata = Druiddata.getDruidata();
    }
    QueryRunner queryRunner = new QueryRunner();
    @Override
    public void Addmsg(Product product) {
        Connection connection = druiddata.getconnection();
        System.out.println(connection);
        String sql = "INSERT INTO product values(?,?,?,?,?,?,?,?,?)";
        try {
            queryRunner.update(connection, sql, product.getPro_id(), product.getPro_name(), product.getPro_price(), product.getPro_image(), product.getPro_des(), product.getPro_stock(), product.getPro_date(), product.getPro_category_id(), product.getPro_factory());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
