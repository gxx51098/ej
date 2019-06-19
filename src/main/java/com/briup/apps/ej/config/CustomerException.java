package com.briup.apps.ej.config;

/**
 * @Author: Li
 * @Date: 2019/6/12 15:36
 * @Description:自定义删除
 */
public class CustomerException extends RuntimeException {
    /**
     * 状态码
     */
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CustomerException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
