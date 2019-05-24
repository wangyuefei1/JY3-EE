package com.neuedu.controller;

import com.neuedu.dao.ProDao;
import com.neuedu.dao.ProDaoimpl;
import com.neuedu.pojo.Product;
import com.neuedu.utils.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "addServlet",urlPatterns = "/add.do")
@MultipartConfig
public class addServlet extends HttpServlet {
    private ProDao proDao;

    @Override
    public void init() throws ServletException {
        proDao = new ProDaoimpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String pro_id = request.getParameter("pro_id");
        String pro_name = request.getParameter("pro_name");
        String pro_price = request.getParameter("pro_price");
        double v = Double.parseDouble(pro_price);
        Part part = request.getPart("pro_image");
        String getname = util.getname(part);
        String pro_des = request.getParameter("pro_des");
        String pro_stock = request.getParameter("pro_stock");
        short i = Short.parseShort(pro_stock);
        String pro_date = request.getParameter("pro_date");
        Date getdate = util.getdate(pro_date);
        String pro_category_id = request.getParameter("pro_category_id");
        short i1 = Short.parseShort(pro_category_id);
        String pro_factory = request.getParameter("pro_factory");
        Product product = new Product(util.getid(),pro_name,v,getname,pro_des,i,getdate,i1,pro_factory);
        proDao.Addmsg(product);
        request.getRequestDispatcher("").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
