package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.service.ICommentService;
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
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @ApiOperation("模糊查询")
    @GetMapping("query")
    public List<Comment> query(Comment comment){
        return commentService.query(comment);
    }
    @ApiOperation("查询所有评价")
    @GetMapping("findAll")
    public Message findAll(){
        List<Comment> list = commentService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(
            @ApiParam(required = true)
            @RequestParam(value = "id") long id){
        Comment comment = commentService.findById(id);
        return MessageUtil.success("success",comment);
    }

    @ApiOperation("保存或更新评价信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Comment comment){
        try {
            commentService.saveOrUpdate(comment);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @ApiOperation("通过id删除评价信息")
    @GetMapping("deleteById")
    public Message deleteById(
            @ApiParam(value = "主键",required = true)
            @RequestParam("id") long id){
        try {
            commentService.deleteById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
}
