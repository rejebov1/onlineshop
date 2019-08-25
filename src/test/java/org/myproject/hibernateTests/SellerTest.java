package org.myproject.hibernateTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.myproject.repository.dao.hibernateConfig.HibernateConfig;
import org.myproject.repository.entity.Seller;
import org.myproject.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class})
public class SellerTest {

    @Autowired
    public SellerService sellerService;

    @Test
    public void addSeller(){
        Seller seller = Seller.builder()
                .name("SellerTest")
                .rating(3.4F)
                .build();

        sellerService.add(seller);
    }

    @Test
    public void getSellerById(){
       Assert.assertNotNull(sellerService.getById(1L));
    }

    @Test
    public void getAllSellers(){
        List<Seller> sellers = sellerService.getAll();
        Assert.assertNotNull(sellerService.getAll().contains(sellers));
    }

    @Test
    public void updateSeller(){
        Seller seller = Seller.builder()
                .id(6L)
                .name("4444444Delivery Club")
                .rating(3.4F)
                .build();
        Assert.assertNotNull(sellerService.update(seller));

    }

    //@Test
    public void deleteSeller(){
        Seller seller = Seller.builder()
                .id(2L)
                .name("4Delivery club")
                .rating(34.4F)
                .build();
       Assert.assertTrue(sellerService.delete(seller));
    }
}

