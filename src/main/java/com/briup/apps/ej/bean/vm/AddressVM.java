package com.briup.apps.ej.bean.vm;

import io.swagger.annotations.ApiParam;

/**
 * @Author: Li
 * @Date: 2019/6/17 21:53
 * @Description:
 */
public class AddressVM {
    @ApiParam(value = "顾客id",required = true)
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
