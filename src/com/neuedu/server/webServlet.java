package com.neuedu.server;

import com.neuedu.dao.userdao;
import com.neuedu.dao.userdaoimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "webServlet" ,urlPatterns = "/hello.do")
public class webServlet extends HttpServlet {

    private userdao ud;
    @Override
    public void init() throws ServletException {
         ud = new userdaoimpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("username");
        String psw = request.getParameter("psw");
        ud.register(user,psw);

        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

}
