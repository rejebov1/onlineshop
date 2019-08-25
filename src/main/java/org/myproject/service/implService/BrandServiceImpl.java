package org.myproject.service.implService;

import org.myproject.repository.dao.hibernateDao.BrandDao;
import org.myproject.repository.entity.Brand;
import org.myproject.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public void add(Brand brand) {
        brandDao.add(brand);

    }
    @Override
    public List<Brand> getByName(String name) {
        return brandDao.getByName(name);
    }

    @Override
    public Brand getById(Long id) {
        return brandDao.getById(id);
    }

    @Override
    public List<Brand> getAll() {
        return brandDao.getAll();
    }

    @Override
    public Brand update(Brand brand) {
        return brandDao.update(brand);
    }

//    @Override
//    public boolean delete(Long id) {
//        return brandDao.delete(id);
//    }

    @Override
    public boolean delete(Brand brand) {
        return brandDao.delete(brand);
    }

}
