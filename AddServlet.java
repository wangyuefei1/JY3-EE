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

@WebServlet(name = "AddServlet",urlPatterns = "/add.do")
public class AddServlet extends HttpServlet {
    private userdao ud;

    @Override
    public void init() throws ServletException {
        ud = new userdaoimpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        ud.Addmsg(username,password);
        request.getRequestDispatcher("user.do").forward(request,response);
    }
}
