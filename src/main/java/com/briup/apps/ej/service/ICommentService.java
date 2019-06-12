package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Comment;

import java.util.List;

public interface ICommentService {

    List<Comment> query(Comment comment);
    List<Comment> findAll();

    Comment findById(long id);

    void saveOrUpdate(Comment comment) throws Exception ;

    void deleteById(long id) throws Exception ;
}