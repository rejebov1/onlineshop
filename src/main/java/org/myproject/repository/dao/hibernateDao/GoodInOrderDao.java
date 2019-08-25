package org.myproject.repository.dao.hibernateDao;

import org.myproject.repository.entity.Cart;
import org.myproject.repository.entity.GoodInOrder;
import org.myproject.repository.entity.compositeKey.GoodInOrderPk;

public interface GoodInOrderDao extends GenericDao<GoodInOrder, GoodInOrderPk> {

    void deleteById(Long id);

    void removeAllGoodsInOrder(Cart cart);
}
