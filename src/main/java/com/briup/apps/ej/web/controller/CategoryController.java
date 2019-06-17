package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.service.ICategoryService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(description = "分类管理相关接口")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Category category){
        List<Category> list = categoryService.query(category);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("查询所有类别")
    @GetMapping("findAll")
    public Message findAll(){
        List<Category> list = categoryService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "id") long id){
        Category category = categoryService.findById(id);
        return MessageUtil.success("success",category);
    }

    @ApiOperation("保存或更新分类信息")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Category category){
        try {
            categoryService.saveOrUpdate(category);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id删除分类信息")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
            categoryService.deleteById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

}