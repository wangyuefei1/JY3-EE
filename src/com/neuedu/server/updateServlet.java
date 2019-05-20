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

@WebServlet(name = "updateServlet", urlPatterns ="/updatepsw")
public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  user =  request.getParameter("username");
        String  psw  =  request.getParameter("password1");
        userdao ud = new userdaoimpl();
        Account account = new Account(user, psw);
        ud.Updatepsw(account);
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}
