package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.extend.AddressExtend;
import com.briup.apps.ej.service.IAddressService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/***
 * 地址管理控制器
 */
@Api(description = "地址管理相关接口")
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @ApiOperation("根据id查找地址信息")
    @GetMapping("findById")
    public Message findById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id")long id) {
        Address address = addressService.findAddressById(id);
        return MessageUtil.success("success", address);
    }
    @GetMapping("findAllAddress")
    @ApiOperation("查询全部地址信息")
    public Message findAllAddress(){
        List<Address> list=addressService.findAllAddress();
        return MessageUtil.success("success",list);
    }
    @GetMapping("query")
    @ApiOperation("根据顾客id，查询该顾客的所有地址")
    public Message query(Long customerId){
        List<AddressExtend> list = addressService.query(customerId);
        return MessageUtil.success("success",list);
    }


    @ApiOperation("添加新地址")
    @PostMapping("insertAddress")
    public Message insertAddress(@Validated @ModelAttribute Address address) throws Exception {
        addressService.insertAddress(address);
        return MessageUtil.success("增加新的地址成功!");
    }

    @ApiOperation("根据id修改地址信息")
    @PostMapping("updateAddressByPrimaryKey")
    public Message updateAddressByPrimaryKey(@Validated@ModelAttribute Address address) throws Exception {
        addressService.updateAddressByPrimaryKey(address);
        return MessageUtil.success("修改地址成功！");
    }

    @PostMapping("deleteAddressById")
    @ApiOperation("根据id删除地址信息")
    public Message deleteAddressById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id) throws  Exception{
        addressService.deleteAddressById(id);
        return MessageUtil.success("删除成功") ;
    }
    @PostMapping("batchDeleteAddress")
    @ApiOperation("批量删除地址信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        addressService.batchDeleteAddress(ids);
        return MessageUtil.success("批量删除成功");
    }
}
