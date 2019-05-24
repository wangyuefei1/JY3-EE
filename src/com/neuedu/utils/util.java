package com.neuedu.utils;

import javax.servlet.http.Part;
import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

public class util {


    public static String getid()
    {
        Random random = new Random();
        int i = random.nextInt(100);
        String str = String.valueOf(System.currentTimeMillis());
        if (i < 10 )
        {
            str += '0'+ i;
        }
        return str += i;
    }

    public  static Date getdate(String string)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        try {
            java.util.Date parse = simpleDateFormat.parse(string);
            date = new Date(parse.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getname(Part part){
        String submittedFileName = part.getSubmittedFileName();
        UUID uuid =  UUID.randomUUID();
        String str = uuid +submittedFileName;
        InputStream is = null;
        OutputStream os = null;
        try {
            is = part.getInputStream();
            os = new FileOutputStream("E:\\img\\"+ str);
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = is.read(bytes))!= -1)
            {
                os.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return  str;
    }

}
