package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Customer;

import com.briup.apps.ej.service.ICustomerService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @ApiOperation("模糊查询")
    @GetMapping("query")
    public List<Customer> query(Customer customer){
        return customerService.query(customer);
    }
    @ApiOperation("查询所有")
    @GetMapping("findAll")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Customer findById(
            @ApiParam(value="主键",required = true)
            @RequestParam(value = "id") long id){
        return customerService.findById(id);
    }

    @ApiOperation("保存或更新客户信息")
    @GetMapping("saveOrUpdate")
    public String saveOrUpdate(Customer customer){
        try {
            customerService.saveOrUpdate(customer);
            return "保存成功!";
        } catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @ApiOperation("通过id删除客户信息")
    @GetMapping("deleteById")
    public Message deleteById(
            @ApiParam(value = "主键",required = true )
            @RequestParam("id") long id){
        try{
            customerService.deleteById(id);
            return MessageUtil.success("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());

        }
    }
}
