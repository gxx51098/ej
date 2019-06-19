package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Category;


import java.util.List;

public interface ICategoryService {

    Category findById(long id);
    List<Category> findAll();

    List<Category> query(Category category);



    //ICategoryService(Category) findAllParentCategory


    List<Category> findAllparentCategory();

    void saveOrUpdate(Category category) throws Exception ;
    void deleteById(long id) throws Exception ;



}