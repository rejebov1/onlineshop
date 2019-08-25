package org.myproject.service;

import org.myproject.repository.entity.Brand;

import java.util.List;


public interface BrandService {

    void add (Brand brand);

    List<Brand> getByName(String name);

    Brand getById(Long id);

    List<Brand> getAll();

    Brand update(Brand brand);

//    boolean delete(Long id);

    boolean delete(Brand brand);
}

