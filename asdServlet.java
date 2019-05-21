package com.neuedu.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "asdServlet")
public class asdServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String key = this.getServletConfig().getInitParameter("key");
//        System.out.println(key);
        List<String> names = new ArrayList();
        names.add("张三");
        names.add("李四");
        names.add("王五") ;                                              ;
        request.setAttribute("name",names);
        request.getRequestDispatcher("Test.jsp").forward(request,response);
    }
}
