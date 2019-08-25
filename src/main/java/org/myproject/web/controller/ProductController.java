package org.myproject.web.controller;

import org.myproject.repository.entity.Product;
import org.myproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable Long productId, Model model) throws IOException {
        Product product = productService.getById(productId);
        model.addAttribute("product", product);
        return "viewProduct";
    }
}