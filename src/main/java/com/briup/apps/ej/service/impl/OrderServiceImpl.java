package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.bean.extend.OrderExtend;
import com.briup.apps.ej.bean.vm.OrderAndOrderLineVM;
import com.briup.apps.ej.bean.vm.OrderVM;
import com.briup.apps.ej.dao.OrderLineMapper;
import com.briup.apps.ej.dao.extend.OrderExtendMapper;
import com.briup.apps.ej.service.IOrderService;
import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.dao.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderExtendMapper orderExtendMapper;
    @Resource
    private OrderLineMapper orderLineMapper;

    @Override
    public List<OrderVM> queryBasic(Long customerId, Long waiterId) {
        return orderExtendMapper.queryBasic(customerId, waiterId);
    }
    @Override
    public Order findOrderById(long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Order> findAllOrder() {
        //创建空模块
        OrderExample example = new OrderExample();
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<OrderExtend> query(Long customerId, Long waiterId) {
        return orderExtendMapper.query(customerId,waiterId);
    }





    @Override
    public List<Order> queryOrder(Order order) {
        // 创建空模板
        OrderExample example = new OrderExample();
        // 在模板中添加条件
        if(order.getId()!=null){
            example.createCriteria().andIdEqualTo(order.getId());
        }
        if(order.getAddressId()!=null){
            example.createCriteria().andAddressIdEqualTo(order.getAddressId());
        }
        if(order.getCustomerId()!=null){
            example.createCriteria().andCustomerIdEqualTo(order.getAddressId());
        }
        if(order.getWaiterId()!=null){
            example.createCriteria().andWaiterIdEqualTo(order.getWaiterId());
        }
        if(order.getOrderTime()!=null){
            example.createCriteria().andOrderTimeEqualTo(order.getOrderTime());
        }
        if(order.getTotal()!=null){
            example.createCriteria().andTotalEqualTo(order.getTotal());
        }

        return orderMapper.selectByExample(example);
    }


    @Override
    public void insertOrder(OrderAndOrderLineVM order) throws Exception {
        //先保存订单
        Order o = new Order();
        o.setOrderTime(new Date().getTime());
        o.setTotal(100.0);
        o.setCustomerId(order.getCustomerId());
        o.setAddressId(order.getAddressId());
        orderMapper.insert(o);
        // 再保存订单项
        List<OrderLine> list = order.getOrderLines();
        for(OrderLine ol : list){
            // 维护订单项与订单之间的关系
            ol.setOrderId(o.getId());
            orderLineMapper.insert(ol);
        }

    }


    @Override
    public void updateOrderPrimaryKey(Order order) throws Exception {
        Order order1=orderMapper.selectByPrimaryKey(order.getId());
        if(order1==null){
            throw new Exception("要修改的订单项不存在！");
        }else{
            orderMapper.updateByPrimaryKeySelective(order);
        }
    }

    @Override
    public void deleteOrderById(long id) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(id);
        if(order == null){
            throw new Exception("要删除的订单不存在");
        } else {
            orderMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public void batchDeleteOrder(long[] ids) throws Exception {
        for(long id : ids){
            orderMapper.deleteByPrimaryKey(id);
        }
    }
}