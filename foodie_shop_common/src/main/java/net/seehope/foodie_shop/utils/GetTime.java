package net.seehope.foodie_shop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 12:10
 */
public class GetTime {
     public static String getTime(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        return df.format(new Date());
    }
}
