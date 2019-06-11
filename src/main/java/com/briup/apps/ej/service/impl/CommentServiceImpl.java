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
    public List<Comment> findAll(){
        CommentExample example = new CommentExample();
        return commentMapper.selectByExample(example);
    }

    @Override
    public Comment findById(long id){
        return commentMapper.selectByPrimaryKey(id);
    }
}
