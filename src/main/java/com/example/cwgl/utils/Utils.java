package com.example.cwgl.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static void log(String msg){
        if (Config.ENABLE_CUSTOMEIZE_LOG){
            System.out.println(dateToStr(null) +" : "+msg);
        }
    }

    public static String dateToStr(Date date){
        if (date==null){
            date = new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
