/**package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Waiter;

import java.util.List;

public interface IWaiterService {


    List<Waiter> query(Waiter waiter);

    List<Waiter> findAll();

    Waiter findById(long id);

    void saveOrUpdate(Waiter waiter) throws Exception ;

    void deleteById(long id) throws Exception ;
}
*/
package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Waiter;

import java.util.List;

/**
 * 服务员接口
 */
public interface IWaiterService {

    //根据id查询
    Waiter findWaiterById(long id);
    //查询所有服务员信息
    List<Waiter> findAllWaiter();

    //模糊查询
    List<Waiter> queryWaiter(Waiter waiter);

    //添加服务员
    void insertWaiter(Waiter waiter)throws Exception;

    //修改服务员的信息
    void updateWaiter(Waiter waiter)throws Exception;
    //根据id删除服务员
    void deleteWaiterById(long id) throws Exception;


    //批量删除服务员信息
    void batchDeleteWaiter(long[] ids) throws Exception;
}