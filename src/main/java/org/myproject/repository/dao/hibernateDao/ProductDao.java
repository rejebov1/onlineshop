package org.myproject.repository.dao.hibernateDao;

import org.myproject.repository.entity.Product;

import java.util.List;


public interface ProductDao extends GenericDao<Product, Long> {
    List<Product> getByName(String name);
}
