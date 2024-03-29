package com.briup.apps.ej.bean.vm;

/**
 * @Author: Li
 * @Date: 2019/6/13 20:47
 * @Description:
 */
import com.briup.apps.ej.bean.OrderLine;
import io.swagger.annotations.ApiParam;

import java.util.List;

public class OrderAndOrderLineVM {
    @ApiParam(value = "顾客id",required = true)
    private Long customerId;
    @ApiParam(value = "服务地址id",required = true)
    private Long addressId;
    private List<OrderLine> orderLines;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
