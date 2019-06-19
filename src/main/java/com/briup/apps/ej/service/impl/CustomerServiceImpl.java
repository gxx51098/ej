package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.CustomerExample;
import com.briup.apps.ej.dao.CustomerMapper;
import com.briup.apps.ej.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CustomerServiceImpl implements ICustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Customer findCustomerById(long id) {
        //调用dao层代码完成操作
        return customerMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<Customer> findCustomerAll() {
        CustomerExample example=new CustomerExample();
        return customerMapper.selectByExample(example);
}


    @Override
    public List<Customer> queryCustomer(Customer customer) {
        // 创建空模板
        CustomerExample example = new CustomerExample();
        // 在模板中添加条件
        if(customer.getRealname()!=null){
            example
                    .createCriteria()
                    .andRealnameLike("%"+customer.getRealname()+"%");
        }
        if(customer.getTelephone()!=null){
            example
                    .createCriteria()
                    .andTelephoneLike("%"+customer.getTelephone()+"%");
        }
        if(customer.getPassword()!=null){
            example.createCriteria().andPasswordEqualTo(customer.getPassword());
        }

        return customerMapper.selectByExample(example);
    }


    @Override
    public  void saveCustomerOrUpdateCustomer(Customer customer) throws Exception{
        Customer customer1=customerMapper.selectByPrimaryKey(customer.getId());
        if(customer1 == null){
            // 初始化属性
            customer.setStatus("正常");
            customerMapper.insert(customer);
        } else {
            customerMapper.updateByPrimaryKey(customer);
        }
    }




    @Override
    public void deleteCustomerById(long id) throws Exception {
        Customer customer=customerMapper.selectByPrimaryKey(id);
        if(customer==null){
            throw  new Exception("要删除顾客不存在");
        }else{
            customerMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public void batchDeleteCustomer(long[] ids) throws Exception {
        for(long id :ids){
            customerMapper.deleteByPrimaryKey(id);
        }
    }

}
