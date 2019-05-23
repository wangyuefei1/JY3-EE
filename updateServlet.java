package com.neuedu.controller;

import com.neuedu.dao.userdao;
import com.neuedu.dao.userdaoimpl;
import com.neuedu.pojo.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateServlet" ,urlPatterns = "/update.do")
public class updateServlet extends HttpServlet {

    private userdao ud;

    @Override
    public void init() throws ServletException {
        ud = new userdaoimpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        String  username =  request.getParameter("username");
        String  password  =  request.getParameter("password");
        Account account = new Account(i,username,password);
        ud.Updatemsg(account);
         response.sendRedirect("/user.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
