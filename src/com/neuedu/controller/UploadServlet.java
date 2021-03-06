package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "UploadServlet",urlPatterns = "/upload.do")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part file1 = request.getPart("file1");
        String submittedFileName = file1.getSubmittedFileName();
        InputStream is = file1.getInputStream();
        OutputStream os = new FileOutputStream("E:\\img\\"+submittedFileName);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes))!= -1)
        {
            os.write(bytes,0,len);
        }
        os.close();
        is.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
