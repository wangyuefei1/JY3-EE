package com.neuedu.controller;

import com.neuedu.pojo.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "showServlet",urlPatterns = "/show.do")
public class showServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = new Account(i,username, password);

        request.setAttribute("account",account);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }
}
