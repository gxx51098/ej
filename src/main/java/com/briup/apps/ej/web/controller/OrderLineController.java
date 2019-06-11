package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.service.IOrderLineService;
import com.briup.apps.ej.service.IOrderService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderLine")
public class OrderLineController {
    @Autowired
    private IOrderLineService orderLineService;

    @ApiOperation("查询所有订单")
    @GetMapping("findAll")
    public Message findAll() {
        List<OrderLine> list = orderLineService.findAll();
        return MessageUtil.success("success", list);
    }

    @ApiOperation("通过id查询订单")
    @GetMapping("findById")
    public Message findById(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "id") long id){
        OrderLine orderLine = orderLineService.findById(id);
        return MessageUtil.success("success",orderLine);
    }



    @ApiOperation("保存或更新订单")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(OrderLine orderline){
        try {
            orderLineService.saveOrUpdate(orderline);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @ApiOperation("通过id删除订单")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
            orderLineService.deleteById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
}