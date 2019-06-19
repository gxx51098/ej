package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.extend.AddressExtend;

import java.util.List;

/***
 * 地址接口
 */
public interface IAddressService {
    //关联查询
    List<AddressExtend> query(Long customerId);
    //List<AddressExtend> queryBasic(Long customerId);

    //根据id查询地址
    Address findAddressById(long id);

    //查看所有地址
    List<Address> findAllAddress();



    //插入新的分类
    void insertAddress(Address address)throws Exception;
    //修改分类
    void updateAddressByPrimaryKey(Address address)throws Exception;

    //根据id删除地址
    void deleteAddressById(long id) throws Exception;
    //批量删除
    void batchDeleteAddress(long[] ids) throws Exception;
}
