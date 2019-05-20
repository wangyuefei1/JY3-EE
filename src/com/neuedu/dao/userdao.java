package com.neuedu.dao;

import com.neuedu.entity.Account;

public interface userdao {

    void register(String user,String psw);
    Account login(Account account);
    void Updatepsw(Account account);
}