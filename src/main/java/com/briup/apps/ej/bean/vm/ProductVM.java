package com.briup.apps.ej.bean.vm;

import io.swagger.annotations.ApiParam;

/**
 * @Author: Li
 * @Date: 2019/6/17 21:59
 * @Description:
 */
public class ProductVM {
    @ApiParam(value = "分类id",required = true)

    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
