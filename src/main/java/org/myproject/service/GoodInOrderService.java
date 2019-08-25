package org.myproject.service;

import org.myproject.repository.entity.Cart;
import org.myproject.repository.entity.GoodInOrder;
import org.myproject.repository.entity.compositeKey.GoodInOrderPk;

import java.util.List;

public interface GoodInOrderService {

    void add(GoodInOrder goodInOrder);

    GoodInOrder getById(GoodInOrderPk id);

    List<GoodInOrder> getAll();

    GoodInOrder update(GoodInOrder order);

    //    boolean delete(Long id);

    void removeAllGoodsInOrder(Cart cart);

    void deleteById(Long id);

    boolean delete(GoodInOrder order);
}
