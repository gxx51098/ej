package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.service.IProductService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(description = "产品管理相关接口")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ApiOperation("查询所有产品")
    @GetMapping("/findAll")
    public Message findAll(){
        List<Product> list = productService.findAll();
        return MessageUtil.success("success",list);
    }


    @ApiOperation("通过id查询产品")
    @GetMapping("/findById")
    public Message findById(long id){
        Product product = productService.findById(id);
        return MessageUtil.success("success",product);
    }

    @ApiOperation("模糊查询")
    @GetMapping("/query")
    public Message query(Product product){
        List<Product> list = productService.query(product);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("更新或添加产品")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(Product product){
        try {
            productService.saveOrUpdate(product);
            return MessageUtil.success("保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("删除产品")
    @PostMapping("/deleteById")
    public Message deleteById(long id){
        try {
            productService.deleteById(id);
            return MessageUtil.success("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
}

