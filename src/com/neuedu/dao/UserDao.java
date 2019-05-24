package com.neuedu.dao;

import java.sql.Date;

public interface UserDao {

    void register (String username, String password, Date date);
}
