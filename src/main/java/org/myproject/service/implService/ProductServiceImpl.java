package org.myproject.service.implService;

import org.myproject.repository.dao.hibernateDao.ProductDao;
import org.myproject.repository.entity.Product;
import org.myproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;


    @Override
    public void add(Product product) {
        productDao.add(product);
    }

    @Override
    public List<Product> getByName(String name) {
        return productDao.getByName(name);
    }

    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

//    @Override
//    public boolean delete(Long id) {
//        return productDao.delete(id);
//    }

    @Override
    public boolean delete(Product product) {
        return productDao.delete(product);
    }

}
