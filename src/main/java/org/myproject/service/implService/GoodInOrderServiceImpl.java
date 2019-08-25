package org.myproject.service.implService;

import org.myproject.repository.dao.hibernateDao.GoodInOrderDao;
import org.myproject.repository.entity.Cart;
import org.myproject.repository.entity.GoodInOrder;
import org.myproject.repository.entity.compositeKey.GoodInOrderPk;
import org.myproject.service.GoodInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodInOrderServiceImpl implements GoodInOrderService {

    @Autowired
    private GoodInOrderDao goodInOrderDao;

    @Override
    public void add(GoodInOrder goodInOrder) {
        goodInOrderDao.add(goodInOrder);
    }

    @Override
    public GoodInOrder getById(GoodInOrderPk id) {
        return goodInOrderDao.getById(id);
    }

    @Override
    public List<GoodInOrder> getAll() {
        return goodInOrderDao.getAll();
    }

    @Override
    public GoodInOrder update(GoodInOrder order) {
        return goodInOrderDao.update(order);
    }

    @Override
    public void removeAllGoodsInOrder(Cart cart) {
        goodInOrderDao.removeAllGoodsInOrder(cart);
    }


    @Override
    public void deleteById(Long id) {
        goodInOrderDao.deleteById(id);
    }

    @Override
    public boolean delete(GoodInOrder order) {
        return false;
    }
}
