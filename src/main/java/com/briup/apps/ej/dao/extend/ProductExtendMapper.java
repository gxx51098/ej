package com.briup.apps.ej.dao.extend;

/**
 * @Author: Li
 * @Date: 2019/6/17 22:06
 * @Description:
 */

import com.briup.apps.ej.bean.extend.ProductExtend;
import com.briup.apps.ej.bean.vm.ProductVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductExtendMapper {
    List<ProductExtend> query(
            @Param("categoryId") Long categoryId
    );


    List<ProductVM> queryBasic(
            @Param("categoryId") Long categoryId
    ) ;
}
