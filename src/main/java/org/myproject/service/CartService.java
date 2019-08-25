package org.myproject.service;

import org.myproject.repository.entity.Cart;
import org.myproject.repository.entity.Product;

import java.util.List;

public interface CartService {

    Cart getCartById(Long CartId);

    List<Cart> getAllProductsInCart(String login);

    void addToCartProduct(String login, Product product);

    void deleteById(Long id);


    List <Product> getCartUser (String login);

    void removeToCartProduct(String login, Long productId);


}
