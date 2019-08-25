package org.myproject.repository.dao.hibernateDaoImpl;

import org.myproject.repository.dao.hibernateDao.OrderDao;
import org.myproject.repository.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order,Long> implements OrderDao {

    public OrderDaoImpl(){
        super();
    }

}
