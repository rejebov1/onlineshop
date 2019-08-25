package org.myproject.service.implService;

import org.myproject.repository.dao.hibernateDao.CartDao;
import org.myproject.repository.dao.hibernateDao.UserDao;
import org.myproject.repository.entity.Cart;
import org.myproject.repository.entity.Product;
import org.myproject.repository.entity.User;
import org.myproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private UserDao userDao;

    public Cart getCartById(Long CartId) {
        return cartDao.getById(CartId);
    }

    @Override
    public List<Cart> getAllProductsInCart(String login) {
        return cartDao.getAll();
    }

    @Override
    public void deleteById(Long id) {
        cartDao.deleteById(id);
    }

    @Override
    public void removeToCartProduct(String email, Long productId) {
        Cart cart;
        User user = userDao.getByEmail(email);//getUserIdByEmail
        cart = cartDao.getCartByUserIdAndProductId(user.getId(), productId);
        cartDao.delete(cart);
    }

    public void addToCartProduct(String email, Product product) {
            User user = userDao.getByEmail(email);
            Cart cart = new Cart();
            cart.setProduct(product);
            cart.setUser(user);
            cartDao.update(cart);
    }

    public List<Product> getCartUser(String login) {
        List<Product> productList = new ArrayList<>();
            productList = cartDao.showCartUser(login);
        return productList;
    }
}
