package com.neuedu.controller;

import com.neuedu.dao.userdao;
import com.neuedu.dao.userdaoimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delServlet" ,urlPatterns = "/del.do")
public class delServlet extends HttpServlet {
    private userdao ud;

    @Override
    public void init() throws ServletException {
        ud = new userdaoimpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int intHeader = request.getIntHeader("id");
        System.out.println(intHeader);
        ud.Delmsg(intHeader);
        request.setAttribute("intHeader",intHeader);
        request.getRequestDispatcher("user.do").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
