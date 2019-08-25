package org.myproject.repository.dao.hibernateDao;

import org.myproject.repository.entity.Brand;

import java.util.List;


public interface BrandDao extends GenericDao<Brand,Long> {
   List<Brand> getByName(String name);
}
