package com.briup.apps.ej.service;


import com.briup.apps.ej.bean.Product;

import java.util.List;

public interface IProductService {

    Product findById(long id);
    List<Product> findAll();

    List<Product> query(Product product);


    void saveOrUpdate(Product product)throws Exception;

    void deleteById(long id)throws Exception    ;

}
