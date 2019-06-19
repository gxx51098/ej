package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.AddressExample;
import com.briup.apps.ej.bean.extend.AddressExtend;
import com.briup.apps.ej.dao.AddressMapper;
import com.briup.apps.ej.dao.extend.AddressExtendMapper;
import com.briup.apps.ej.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;
    @Resource
    private AddressExtendMapper addressExtendMapper;

    @Override
    public Address findAddressById(long id) {
        //调用dao层代码完成操作
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Address> findAllAddress() {
        AddressExample example=new AddressExample();
        return addressMapper.selectByExample(example);
    }

    @Override
    public List<AddressExtend> query(Long customerId) {
        return addressExtendMapper.query(customerId);
    }

    @Override
    public void insertAddress(Address address) throws Exception {
        Address address1=addressMapper.selectByPrimaryKey(address.getId());
        if(address1==null){
            addressMapper.insert(address);
        }else{
            throw new Exception("id已存在");
        }

    }

    @Override
    public void updateAddressByPrimaryKey(Address address) throws Exception {
        Address category1=addressMapper.selectByPrimaryKey(address.getId());
        if(category1==null){
            throw new Exception("要修改的地址不存在！");
        }else{
            addressMapper.updateByPrimaryKeySelective(address);
        }
    }
    @Override
    public void deleteAddressById(long id) throws Exception {
        Address customer=addressMapper.selectByPrimaryKey(id);
        if(customer==null){
            throw  new Exception("要删除地址不存在");
        }else{
            addressMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void batchDeleteAddress(long[] ids) throws Exception {
        for(long id :ids){
            addressMapper.deleteByPrimaryKey(id);
        }
    }
}
