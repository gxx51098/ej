package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.extend.OrderExtend;
import com.briup.apps.ej.bean.vm.OrderAndOrderLineVM;
import com.briup.apps.ej.service.IOrderService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@Validated
@RestController
@RequestMapping("/order")
@Api(description = "订单管理相关接口")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @ApiOperation("通过id查询订单信息")
    @GetMapping("findOrderById")
    public Message findOrderById(@ApiParam(required = true) @RequestParam(value = "id") @NotNull long id){
        Order order = orderService.findOrderById(id);
        return MessageUtil.success("success",order);
    }


    @ApiOperation("查询所有订单信息")
    @GetMapping("findAllOrder")
    public Message findAllOrder(){
        List<Order> list = orderService.findAllOrder();
        return MessageUtil.success("success",list);
    }

    @GetMapping("query")
    @ApiOperation("查询订单详细信息，级联查询")
    public Message query(Long customerId,Long waiterId){
        List<OrderExtend> list = orderService.query(customerId,waiterId);
        return MessageUtil.success("success",list);
    }


    @ApiOperation("查询订单信息")
    @GetMapping("queryOrder")
    public Message queryOrder(Order order){
        List<Order> list = orderService.queryOrder(order);
        return MessageUtil.success("success",list);
    }



    @ApiOperation("新增订单信息")
    @PostMapping("insertOrder")
    public Message insertOrder(@Validated@ModelAttribute OrderAndOrderLineVM order) throws Exception {
        orderService.insertOrder(order);
        return MessageUtil.success("增加新的分类成功!");
    }

    @ApiOperation("根据id修改订单信息")
    @PostMapping("updateOrderPrimaryKey")
    public Message updateOrderPrimaryKey(@Validated@ModelAttribute Order order) throws Exception {
        orderService.updateOrderPrimaryKey(order);
        return MessageUtil.success("修改分类成功！");
    }


    @ApiOperation("通过id删除订单信息")
    @PostMapping("deleteOrderById")
    public Message deleteOrderById(@ApiParam(value = "主键",required = true) @RequestParam("id") @NotNull long id){
        try {
            orderService.deleteOrderById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @PostMapping("batchDeleteOrder")
    @ApiOperation("批量删除")
    public Message batchDeleteOrder(long[] ids) throws Exception{
        orderService.batchDeleteOrder(ids);
        return MessageUtil.success("批量删除成功");
    }


}