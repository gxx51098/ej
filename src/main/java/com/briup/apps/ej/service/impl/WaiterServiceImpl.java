package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.bean.WaiterExample;
import com.briup.apps.ej.dao.WaiterMapper;
import com.briup.apps.ej.service.IWaiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class WaiterServiceImpl implements IWaiterService {
    @Resource
    private WaiterMapper waiterMapper;


    @Override
    public List<Waiter> findAllWaiter() {
        WaiterExample example=new WaiterExample();
        return waiterMapper.selectByExample(example);
    }


    @Override
    public Waiter findWaiterById(long id) {
        //调用dao层代码完成操作
        return waiterMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<Waiter> queryWaiter(Waiter waiter){
        return waiterMapper.query(waiter);
    }

    @Override
    public void insertWaiter(Waiter waiter) throws  Exception{
        waiterMapper.insertSelective(waiter);
    }




    @Override
    public void updateWaiter(Waiter waiter) {
        waiterMapper.updateByPrimaryKeySelective(waiter);
    }


    @Override
    public void deleteWaiterById(long id) throws Exception {
        Waiter customer=waiterMapper.selectByPrimaryKey(id);
        if(customer==null){
            throw  new Exception("要删除服务员不存在");
        }else{
            waiterMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void batchDeleteWaiter(long[] ids) throws Exception {
        for(long id :ids){
            waiterMapper.deleteByPrimaryKey(id);
        }
    }
}