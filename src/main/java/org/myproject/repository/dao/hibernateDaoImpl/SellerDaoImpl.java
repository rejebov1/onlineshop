package org.myproject.repository.dao.hibernateDaoImpl;

import org.myproject.repository.dao.hibernateDao.SellerDao;
import org.myproject.repository.entity.Seller;
import org.springframework.stereotype.Repository;

@Repository
public class SellerDaoImpl extends GenericDaoImpl<Seller, Long> implements SellerDao {

    public SellerDaoImpl() {
        super();
    }

}

