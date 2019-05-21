package com.neuedu.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestServlet" ,urlPatterns = "/text")
public class TestServlet extends HttpServlet {

//    @Override
//    public void init() throws ServletException {
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       String contextPath = req.getContextPath();
//       System.out.println("路径"+contextPath);
//       String method = req.getMethod();
//       System.out.println("提交方法"+method);
//       String requestURI = req.getRequestURI();
//       System.out.println(requestURI);
//       String queryString = req.getQueryString();
//       System.out.println(queryString );
//       String protocol = req.getProtocol();
//        System.out.println(protocol);
//        String servletPath = req.getServletPath();
//        System.out.println(servletPath);
//    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //转发   可访问WEB-INF下的文件
        //request.getRequestDispatcher("").forward(request,response);
        //重定向
        response.sendRedirect("https://www.baidu.com");

    }
}
