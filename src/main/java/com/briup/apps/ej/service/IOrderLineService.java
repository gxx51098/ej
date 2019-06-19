package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.OrderLine;

import java.util.List;


public interface IOrderLineService {

    //根据id查询
    OrderLine findOrderLineById(long id);
    //查询所有
    List<OrderLine> findAllOrderLine();
    //模糊查询
    List<OrderLine> query(OrderLine orderLine);

    //新增订单项
    void insertOrderLine(OrderLine orderLine)throws Exception;
    //修改订单项
    void updateOrderLinePrimaryKey(OrderLine orderLine)throws Exception;
    //根据id删除
    void deleteOrderLineById(long id) throws Exception ;
    //批量删除
    void batchDeleteOrderLine(long ids[]) throws Exception ;
}
