package org.myproject.service;

import org.myproject.repository.entity.Seller;

import java.util.List;

public interface SellerService {

    void add(Seller seller);

    Seller getById(Long id);

    List<Seller> getAll();

    Seller update(Seller seller);

//    boolean delete(Long id);

    boolean delete(Seller seller);


}
