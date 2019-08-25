package org.myproject.repository.dao.hibernateDaoImpl;


import org.hibernate.query.Query;
import org.myproject.repository.dao.hibernateDao.GoodInOrderDao;
import org.myproject.repository.entity.Cart;
import org.myproject.repository.entity.GoodInOrder;
import org.myproject.repository.entity.compositeKey.GoodInOrderPk;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class GoodInOrderDaoImpl extends GenericDaoImpl<GoodInOrder, GoodInOrderPk> implements GoodInOrderDao {

//    private GoodInOrderDao goodInOrderDao;

    public GoodInOrderDaoImpl() {
        super();

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("delete GoodInOrder where id = :id");
        query.setParameter("id", id);
    }


//    @Override
//    public GoodInOrder getById(GoodInOrderPk id) {
//        return goodInOrderDao.getById(id);
//    }


    @Override
    public void removeAllGoodsInOrder(Cart cart) {
        List<GoodInOrder> goodInOrders = cart.getGoodInOrders();
        for (GoodInOrder goodInOrder : goodInOrders) {
            deleteById(goodInOrder.getId());
        }
    }
}
