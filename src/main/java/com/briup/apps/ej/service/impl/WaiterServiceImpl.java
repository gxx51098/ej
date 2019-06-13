package com.briup.apps.ej.service.impl;
import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.dao.WaiterMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.briup.apps.ej.bean.*;
import com.briup.apps.ej.service.IWaiterService;

@Service
public class WaiterServiceImpl implements IWaiterService{
    // 自动注入mapper实例
    @Resource
    private WaiterMapper waiterMapper;

    @Override
    public List<Waiter> query(Waiter waiter) {
        // 创建空模板
        WaiterExample example = new WaiterExample();
        // 在模板中添加条件
        WaiterExample.Criteria c = example.createCriteria();
        if (waiter.getTelephone()!=null){
            c.andTelephoneLike("%"+waiter.getTelephone()+"%");
        }
        if (waiter.getPassword()!=null){
            c.andPasswordLike("%"+waiter.getPassword()+"%");
        }
        if (waiter.getRealname()!=null){
            c.andRealnameLike("%"+waiter.getRealname()+"%");
        }
        if (waiter.getIdcard()!=null){
            c.andIdcardLike("%"+waiter.getIdcard()+"%");
        }
        if (waiter.getStatus()!=null){
            c.andStatusLike("%"+waiter.getStatus()+"%");
        }
        if (waiter.getPhoto()!=null){
            c.andPhotoLike("%"+waiter.getPhoto()+"%");
        }
        return waiterMapper.selectByExample(example);
    }

    @Override
    public List<Waiter> findAll() {
        WaiterExample example=new WaiterExample();
        return waiterMapper.selectByExample(example);
        //return null;
    }

    @Override
    public Waiter findById(long id) {
        return waiterMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Waiter waiter) throws Exception{
        if (waiter.getId()==null){
            waiterMapper.insert(waiter);
        }else {
            //waiterMapper.updateByPrimaryKeySelective(waiter);
                    waiterMapper.updateByPrimaryKey(waiter);
        }

    }

    @Override
    public void deleteById(long id) throws Exception{
        Waiter waiter = waiterMapper.selectByPrimaryKey(id);
        if (waiter.getId()==null){
            throw new Exception("该waiter不存在！");
        }else {
            waiterMapper.deleteByPrimaryKey(id);
        }
    }
}
