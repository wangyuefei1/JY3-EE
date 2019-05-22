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
    public void Updatamsg(Account account,String newpsw) {
        Connection connection = druiddata.getconnection();
        String sql = "UPDATE account set password = ? WHERE username = ? AND password = ?";
        try {
            int update = queryRunner.update(connection, sql,newpsw,account.getUsername(),account.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delmsg(int id) {
        Connection connection = druiddata.getconnection();
        String sql = "DELETE FROM account where id = ?";
        try {
            int update = queryRunner.update(connection, sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
