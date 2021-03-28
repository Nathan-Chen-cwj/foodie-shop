package net.seehope.foodie_shop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2020/9/5 0:18
 */
public class GetOrderMsg {
    /**
     * 生成18位数的订单号
     * @return 订单号
     */
    public static String getOrderId(){
        Date date = new Date();
        SimpleDateFormat df= new SimpleDateFormat("yyyyMMddhhmmss");
        String format = df.format(date);
        String r = String.valueOf((int)(Math.random()*8998)+1000+1);
        return format+r;
    }

    /**
     * 获取当前时间用于作为交易时间
     * @return
     */
    public static String getTradeTime(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        return df.format(date);
    }
}
