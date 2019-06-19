package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.Product;

/**
 * @Author: Li
 * @Date: 2019/6/17 21:55
 * @Description:
 */
public class ProductExtend extends Product {
    private Category category;
    public  Category getCategory() {return  category;}
    public  void  setCategory(Category category){this.category = category;}
}