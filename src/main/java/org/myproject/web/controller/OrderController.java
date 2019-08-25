package org.myproject.web.controller;

import org.myproject.repository.entity.Product;
import org.myproject.repository.entity.User;
import org.myproject.service.OrderService;
import org.myproject.service.ProductService;
import org.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/{productId}", method = RequestMethod.GET)
    public String checkout(Model model, @PathVariable Long productId) {
        Optional<Product> productOp = Optional.ofNullable(productService.getById(productId));
        Product product = new Product();
        if (productOp.isPresent()) {
            product = productOp.get();
        }
        model.addAttribute("product", product);
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "order";
    }

}
