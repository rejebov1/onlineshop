package org.myproject.repository.dao.hibernateDao;

import org.myproject.repository.entity.Cart;
import org.myproject.repository.entity.Product;

import java.io.IOException;
import java.util.List;

public interface CartDao extends GenericDao<Cart,Long> {

    Cart validate(Long cartId) throws IOException;

    void deleteById(Long id);

    List<Product> showCartUser(String login);

    Cart getCartByUserIdAndProductId (Long userId, Long productId);
}
