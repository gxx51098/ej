package com.briup.apps.ej.utils;

import java.util.Date;

/***
 * 消息工具
 */
public class MessageUtil {
    /**
     * 返回成功消息,一般用于增删改查
     */
    public static  Message success(String msg){
        Message message=new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    /**
     * 返回成功消息,一般用于查询操作
     */
    public static Message success(String msg, Object data){
        Message message=new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setData(data);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    /**
     *返回失败消息
     */
    public static Message error( String msg){
        Message message=new Message();
        message.setStatus(500);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    /**
     * 返回失败消息
     */
    public static Message error(Integer code, String msg){
        Message message=new Message();
        message.setStatus(500);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }
}
