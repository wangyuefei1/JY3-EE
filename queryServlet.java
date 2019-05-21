package com.neuedu.server;

import com.neuedu.dao.userdao;
import com.neuedu.dao.userdaoimpl;
import com.neuedu.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "queryServlet",urlPatterns = "/query.do")
public class queryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        userdao ud = new userdaoimpl();
        List<Account> account = ud.Query();
        List<String> usernames = new ArrayList();
        List<String> passwords = new ArrayList();
        for (int i=0;i<account.size();i++)
        {
            usernames.add(account.get(i).getUsername());
            passwords.add(account.get(i).getPassword());
        }
//       System.out.println(account.get(0).getUsername());
        request.setAttribute("username",usernames);
        request.setAttribute("password",passwords);
        request.getRequestDispatcher("query.jsp").forward(request,response);
    }
}
