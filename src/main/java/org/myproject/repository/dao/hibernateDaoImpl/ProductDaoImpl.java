package org.myproject.repository.dao.hibernateDaoImpl;

import  org.hibernate.query.Query;
import org.myproject.repository.dao.hibernateDao.ProductDao;
import org.myproject.repository.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product,Long> implements ProductDao {

    public ProductDaoImpl(){
        super();
    }

    @Override
    @Transactional
    public List<Product> getByName(String name) {
        Query<Product> query = sessionFactory.getCurrentSession()
                .createQuery("from Product p where p.name=:name", Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
//from Product p where p.name=:name
}
