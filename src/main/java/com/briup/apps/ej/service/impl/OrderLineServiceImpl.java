package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.bean.OrderLineExample;
import com.briup.apps.ej.bean.extend.OrderExtend;
import com.briup.apps.ej.dao.OrderLineMapper;
import com.briup.apps.ej.dao.extend.OrderExtendMapper;
import com.briup.apps.ej.service.IOrderLineService;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * 订单项接口实现
 */
@Service
public class OrderLineServiceImpl implements IOrderLineService {
    @Resource
    private OrderLineMapper orderLineMapper;
    @Resource
    private OrderExtendMapper orderExtendMapper;

    @Override
    public OrderLine findOrderLineById(long id) {
        return orderLineMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OrderLine> findAllOrderLine() {
        //创建空模块
        OrderLineExample example = new OrderLineExample();
        return orderLineMapper.selectByExample(example);
    }


    @Override
    public List<OrderLine> query(OrderLine orderLine) {
        // 创建空模板
        OrderLineExample example = new OrderLineExample();
        // 在模板中添加条件
        if(orderLine.getId()!=null){
            example.createCriteria().andIdEqualTo(orderLine.getId());
        }
        if(orderLine.getOrderId()!=null){
            example.createCriteria().andOrderIdEqualTo(orderLine.getOrderId());
        }
        if(orderLine.getProductId()!=null){
            example.createCriteria().andProductIdEqualTo(orderLine.getProductId());
        }
        if(orderLine.getNumber()!=null){
            example.createCriteria().andNumberEqualTo(orderLine.getNumber());
        }


        return orderLineMapper.selectByExample(example);
    }


    @Override
    public void insertOrderLine(OrderLine orderLine) throws Exception {
        OrderLine orderLine1=orderLineMapper.selectByPrimaryKey(orderLine.getId());
        if(orderLine1==null){

            orderLineMapper.insert(orderLine);
        }else{
            throw new Exception("id已存在");
        }

    }


    @Override
    public void updateOrderLinePrimaryKey(OrderLine orderLine) throws Exception {
        OrderLine orderLine1=orderLineMapper.selectByPrimaryKey(orderLine.getId());
        if(orderLine1==null){
            throw new Exception("要修改的订单项不存在！");
        }else{
            orderLineMapper.updateByPrimaryKeySelective(orderLine);
        }
    }


    @Override
    public void deleteOrderLineById(long id) throws Exception {
        OrderLine orderLine = orderLineMapper.selectByPrimaryKey(id);
        if(orderLine == null){
            throw new Exception("要删除的订单不存在");
        } else {
            orderLineMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public void batchDeleteOrderLine(long[] ids) throws Exception {
        for(long id : ids){
            orderLineMapper.deleteByPrimaryKey(id);
        }
    }
}
