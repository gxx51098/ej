package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.ProductExample;
import com.briup.apps.ej.dao.ProductMapper;
import com.briup.apps.ej.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        ProductExample example = new ProductExample();
        return productMapper.selectByExample(example);
    }

    @Override
    public List<Product> query(Product product) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria c = example.createCriteria();
        if (product.getDescription()!=null){
            c.andDescriptionLike("%"+product.getDescription()+"%");
        }
        if (product.getName()!=null){
            c.andDescriptionNotLike("%"+product.getName()+"%");
        }
        if (product.getCategoryId()!=null){
            c.andDescriptionNotLike("%"+product.getCategoryId()+"%");
        }
        if (product.getPhoto()!=null){
            c.andDescriptionNotLike("%"+product.getPhoto()+"%");
        }
        if (product.getPrice()!=null){
            c.andDescriptionNotLike("%"+product.getPrice()+"%");
        }
        if (product.getStatus()!=null){
            c.andDescriptionNotLike("%"+product.getStatus()+"%");
        }
        return productMapper.selectByExample(example);
    }

    @Override
    public Product findById(long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Product product) throws Exception{
        if (product.getId()==null){
            productMapper.insert(product);
        }else {
            productMapper.updateByPrimaryKey(product);
        }

    }

    @Override
    public void deleteById(long id) throws Exception{
        Product product = productMapper.selectByPrimaryKey(id);
        if (product.getId()==null){
            throw new Exception("该商品不存在！");
        }else {
            productMapper.deleteByPrimaryKey(id);
        }
    }
}
