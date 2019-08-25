package org.myproject.web.controller;

import org.myproject.repository.entity.Cart;
import org.myproject.repository.entity.Product;
import org.myproject.repository.entity.User;
import org.myproject.service.CartService;
import org.myproject.service.ProductService;
import org.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(Model model) {
        Cart listCart;
        User user = userService.getCurrentUser();
        listCart = cartService.getCartById(user.getId());
        model.addAttribute("carts", listCart);

        return "cart";
    }


    @RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.POST)
    public String cart(@Valid @ModelAttribute("user") User user, BindingResult resultUser, Model model,
                       @PathVariable Long productId) {

        Optional<Product> productOp = Optional.ofNullable(productService.getById(productId));
        Product product = new Product();
        if (productOp.isPresent()) {
            product = productOp.get();
        }
        model.addAttribute("product", product);

        return "cart";
    }
}

