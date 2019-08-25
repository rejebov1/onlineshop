package org.myproject.service;

import org.myproject.repository.entity.Product;

import java.util.List;

public interface ProductService {

    void add(Product product);

    List<Product> getByName(String name);

    Product getById(Long id);

    List<Product> getAll();

    Product update(Product product);

//    boolean delete(Long id);

    boolean delete(Product product);

}
