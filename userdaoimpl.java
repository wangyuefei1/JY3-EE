package com.neuedu.dao;

import com.neuedu.dataSource.Druiddata;
import com.neuedu.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class userdaoimpl implements userdao {
    private QueryRunner queryRunner;

    private Druiddata druiddata = Druiddata.getDruidata();
    public userdaoimpl()
    {
        queryRunner = new QueryRunner();
    }
    @Override
    public List<Account> getAccount() {
        List<Account> accounts = null;
        Connection connection = druiddata.getconnection();
        String sql = "SELECT * FROM account";
        try {
            accounts = queryRunner.query(connection, sql, new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public void Updatemsg(Account account) {
        Connection connection = druiddata.getconnection();
        String sql = "UPDATE account set username = ? ,password = ?  WHERE id = ?";
        try {
         queryRunner.update(connection, sql,account.getUsername(),account.getPassword(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delmsg(int id) {
        Connection connection = druiddata.getconnection();
        String sql = "DELETE FROM account where id = ?";
        try {
             queryRunner.update(connection, sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Addmsg(String username,String password) {
        Connection connection = druiddata.getconnection();
        String sql = "INSERT INTO account(username,password) values(?,?)";
        try {
            queryRunner.update(connection,sql,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
