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

@WebServlet(name = "loginServlet",urlPatterns ="/login.do" )
public class loginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  user =  request.getParameter("username");
        String  psw  =  request.getParameter("password");
        userdao ud = new userdaoimpl();
        Account account = new Account(user, psw);
        Account login1 = ud.login(account);
        if(null != login1)
        {
            request.setAttribute("user",user);
            request.getRequestDispatcher("loginsuc.jsp").forward(request,response);
        }
        else
        {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

}
