package org.myproject.web.controller;

import org.myproject.repository.entity.Cart;
import org.myproject.repository.entity.GoodInOrder;
import org.myproject.repository.entity.Product;
import org.myproject.repository.entity.User;
import org.myproject.service.CartService;
import org.myproject.service.GoodInOrderService;
import org.myproject.service.ProductService;
import org.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class GoodInOrderController {
    @Autowired
    private CartService cartService;

    @Autowired
    private GoodInOrderService goodInOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/cart/add/{productId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addCartItem(@PathVariable(value = "productId") Long productId) {
       /* Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();*/
        User currentUser = userService.getCurrentUser();
        String email = currentUser.getEmail();
        User user = userService.getByEmail(email);

        Cart cart = user.getCart();
        List<GoodInOrder> goodInOrders = cart.getGoodInOrders();
        Product product = productService.getById(productId);

        for (int i = 0; i < goodInOrders.size(); i++) {
            GoodInOrder goodInOrder = goodInOrders.get(i);
            if (product.getId() == (goodInOrder.getProduct().getId())) {
                goodInOrder.setQuantityOfGoodsInTheOrder(goodInOrder.getQuantityOfGoodsInTheOrder() + 1);
                /*goodInOrder.setPrice(goodInOrder.getProduct().getPrice().multiply(new BigDecimal(goodInOrder.getQuantityOfGoodsInTheOrder())));*/
                goodInOrderService.add(goodInOrder);
                return;
            }
        }

        GoodInOrder goodInOrder = new GoodInOrder();
        goodInOrder.setQuantityOfGoodsInTheOrder(1);
        goodInOrder.setProduct(product);
/*        goodInOrder.setPrice(product.getPrice());*/
        goodInOrder.setCart(cart);
        goodInOrderService.add(goodInOrder);
    }

    @RequestMapping("/cart/removeCartItem/{goodInOrderId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeCartItem(@PathVariable(value = "goodInOrderId") Long goodInOrderId) {
        goodInOrderService.deleteById(goodInOrderId);
    }

    @RequestMapping("/cart/removeAllItems/{cartId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeAllCartItems(@PathVariable(value = "cartId") Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        goodInOrderService.removeAllGoodsInOrder(cart);
    }
}


