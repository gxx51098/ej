package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.service.IWaiterService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/waiter")
@Api(description = "服务员管理相关接口")
public class WaiterController {
    @Autowired
    private IWaiterService waiterService;

    @ApiOperation("根据id查询服务员信息")
    @GetMapping("findWaiterById")
    public Message findWaiterById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        Waiter waiter=  waiterService.findWaiterById(id);
        return MessageUtil.success("查询成功",waiter);

    }
    @GetMapping("findAllWaiter")
    @ApiOperation("查询所有服务员信息")
    public Message findAllWaiter(){
        List<Waiter> list=waiterService.findAllWaiter();
        return MessageUtil.success("success",list);
    }


    @ApiOperation("模糊查询")
    @GetMapping("queryWaiter")
    public Message queryWaiter(Waiter waiter){
        List<Waiter> list=waiterService.queryWaiter(waiter);
        return MessageUtil.success("success",list);
    }


    @ApiOperation("新增服务员")
    @PostMapping("insertWaiter")
    public Message insertWaiter(Waiter waiter) throws Exception {
        waiter.setStatus("1");
        waiterService.insertWaiter(waiter);
        return MessageUtil.success("添加服务员成功！");
    }


    @ApiOperation("修改服务员信息")
    @PostMapping("updateWaiter")
    public Message updateWaiter(Waiter waiter) throws  Exception{
        waiterService.updateWaiter(waiter);
        return MessageUtil.success("更新产品成功！");
    }
    @GetMapping("deleteWaiterById")
    @ApiOperation("通过id删除服务员信息")
    public Message deleteWaiterById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id) throws  Exception{
        waiterService.deleteWaiterById(id);
        return MessageUtil.success("删除成功") ;
    }

    @PostMapping("batchDeleteWaiter")
    @ApiOperation("批量删除服务员信息")
    public Message batchDeleteWaiter(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        waiterService.batchDeleteWaiter(ids);
        return MessageUtil.success("批量删除成功");
    }
}