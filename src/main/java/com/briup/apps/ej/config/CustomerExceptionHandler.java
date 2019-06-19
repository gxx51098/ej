package com.briup.apps.ej.config;



import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/***
 * 统一异常处理
 */
@RestControllerAdvice
/**
 * @Author: Li
 * @Date: 2019/6/12 15:36
 * @Description:
 */
public class CustomerExceptionHandler {
    @ExceptionHandler(value =  Exception.class) // 捕获 Controller 中抛出的指定类型的异常，也可以指定其他异常
    public <E> Message<E> handler(Exception exception){
        exception.printStackTrace();
        return MessageUtil.error(exception.getMessage());
/**
 if (exception instanceof CustomerException){
 CustomerException customerException= (CustomerException) exception;
 exception.printStackTrace();
 return  MessageUtil.error(customerException.getCode(),customerException.getMessage());
 } else {
 exception.printStackTrace();
 return MessageUtil.error(500, "异常信息：" + exception.getMessage());
 }*/
    }
}
