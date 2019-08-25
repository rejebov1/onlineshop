package org.myproject.repository.dao.hibernateDaoImpl;

import org.hibernate.query.Query;
import org.myproject.repository.dao.hibernateDao.BrandDao;
import org.myproject.repository.entity.Brand;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BrandDaoImpl extends GenericDaoImpl<Brand, Long> implements BrandDao {

    public BrandDaoImpl() {
        super();
    }

    @Override
    @Transactional
    public List<Brand> getByName(String name) {
        Query<Brand> query = sessionFactory.getCurrentSession()
                .createQuery("from Brand b where b.name=:name", Brand.class);
        query.setParameter("name", name);
        return query.getResultList();

    }
}
