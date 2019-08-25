package org.myproject.hibernateTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.myproject.repository.dao.hibernateConfig.HibernateConfig;
import org.myproject.repository.entity.Brand;
import org.myproject.repository.entity.Product;
import org.myproject.service.BrandService;
import org.myproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class})
public class ProductAndBrandTest {

    @Autowired
    public ProductService productService;                         // 1 add 2 getById 3 getAll 4 update 5 delete(obj) 6 deleteById

    @Autowired
    public BrandService brandService;

    @Test
    public void ProductAndBrandAdd() {

        Product product = new Product();
        product.setName("S8");
        product.setProductCharacteristic("Simple in use(:");
        product.setPrice(new BigDecimal(55230.1));
        product.setDateOfIssue(LocalDate.now());
        product.setBrand(Brand.builder()
                .name("Samsung")
                .country("South Korea")
                .build());
        productService.add(product);
        assertNotNull("OK", productService.getAll().contains(product));

    }

    //@Test
    public void ProductAndBrandGetById() {
        Assert.assertNotNull(productService.getById(1L));
    }

    @Test
    public void ProductAndBrandGetAll() {
        List<Product> products = productService.getAll();
        Assert.assertNotNull(products);
    }

    @Test
    public void ProductGetByName() {
        System.out.println(productService.getByName("X"));
    }

    @Test
    public void BrandGetByName() {
        System.out.println(brandService.getByName("Sony"));
    }

    @Test
    public void ProductAndBrandUpdate() {
        Brand brand = Brand.builder()
                .name("BLU")
                .country("USA")
                .build();
        Product product = Product.builder()
                .id(2L)
                .name("NewModel")
                .dateOfIssue(LocalDate.now())
                .productCharacteristic("Test")
                .price(new BigDecimal(230.1))
                .brand(brand)
                .build();

        productService.update(product);
        Assert.assertNotNull("Updated",product);
    }


    @Test
    public void ProductAndBrandDeleteById() {

        Product product = productService.getById(1L);
        productService.delete(product);
        assertNull(productService.getById(1L));
    }

}
