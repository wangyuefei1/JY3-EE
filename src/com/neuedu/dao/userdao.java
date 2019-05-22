package com.neuedu.dao;

import com.neuedu.pojo.Account;

import java.util.List;

public interface userdao {
    List<Account> getAccount();
    void Updatamsg(Account account,String newpsw);
    void Delmsg(int id);
}
