package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.CommentExample;
import com.briup.apps.ej.dao.CommentMapper;
import com.briup.apps.ej.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    private CommentMapper commentMapper;


    @Override
    public List<Comment> findAll() {
        CommentExample example = new CommentExample();
        return commentMapper.selectByExample(example);
    }


    @Override
    public Comment findById(long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Comment comment) throws Exception {
        if (comment.getId() == null) {
            // 初始化属性
            commentMapper.insert(comment);
        } else {
            commentMapper.updateByPrimaryKey(comment);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Comment order = commentMapper.selectByPrimaryKey(id);
        if (order == null) {
            throw new Exception("要删除的订单不存在");
        } else {
            commentMapper.deleteByPrimaryKey(id);
        }
    }

}