package com.briup.apps.ej.dao.extend;

import com.briup.apps.ej.bean.extend.AddressExtend;
import com.briup.apps.ej.bean.vm.AddressVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Li
 * @Date: 2019/6/17 22:05
 * @Description:
 */
public interface AddressExtendMapper {
    List<AddressExtend> query(
            @Param("customerId") Long customerId

    );

}
