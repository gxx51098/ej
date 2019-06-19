package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Customer;

import java.util.List;

public interface ICustomerService {

    //根据id查询
    Customer findCustomerById(long id);
    //查询全部商品
    List<Customer> findCustomerAll();

    //模糊查询
    List<Customer> queryCustomer(Customer customer);


    //保存和修改操作
    void saveCustomerOrUpdateCustomer(Customer customer) throws Exception;

    //根据id删除
    void deleteCustomerById(long id) throws Exception;


    //批量删除
    void batchDeleteCustomer(long[] ids) throws Exception;
}
