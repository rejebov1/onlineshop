package org.myproject.service.implService;

import org.myproject.repository.dao.hibernateDao.SellerDao;
import org.myproject.repository.entity.Seller;
import org.myproject.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerDao sellerDao;

    @Override
    public void add(Seller seller) {
        sellerDao.add(seller);
    }

    @Override
    public Seller getById(Long id) {
        return sellerDao.getById(id);
    }

    @Override
    public List<Seller> getAll() {
        return sellerDao.getAll();
    }

    @Override
    public Seller update(Seller seller) {
        return sellerDao.update(seller);
    }

//    @Override
//    public boolean delete(Long id) {
//        return sellerDao.delete(id);
//    }

    @Override
    public boolean delete(Seller seller) {
        return sellerDao.delete(seller);
    }


}
