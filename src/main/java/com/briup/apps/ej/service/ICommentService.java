package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Comment;

import java.util.List;

public interface ICommentService {
    Comment findById(long id);

    List<Comment> findAll();
    List<Comment> query(Comment comment);




    void saveOrUpdate(Comment comment) throws Exception ;

    void deleteById(long id) throws Exception ;
}