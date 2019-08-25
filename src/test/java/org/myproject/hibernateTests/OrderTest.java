package org.myproject.hibernateTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.myproject.repository.dao.hibernateConfig.HibernateConfig;
import org.myproject.repository.entity.GoodInOrder;
import org.myproject.repository.entity.compositeKey.GoodInOrderPk;
import org.myproject.service.GoodInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class})
public class OrderTest {

    @Autowired
    private GoodInOrderService goodInOrderService;


    //@Test
   /* public void whenPersistedGoodInOrder_thenRetrievedFromDb() {
        Order order = Order.builder()
                .id(5L)
                .address("testAddress")
                .dateOfOrder(LocalDate.now())
                .deliveryDate(LocalDate.now())
                .goodInOrder(new ArrayList<>())
                .status(OrderStatus.REVIEWING)
                .build();

        Brand brand = Brand.builder()
                .country("testCountry")
                .name("testName")
                .build();
        Product product = Product.builder()
                .id(5L)
                .brand(brand)
                .price(1.1)
                .productCharacteristic("productCharacTest")
                .dateOfIssue(LocalDate.now())
                .name("testPhoneModel")
                .build();
        GoodInOrder testGoodInOrder = GoodInOrder.builder()
                .id(new GoodInOrderPk(order.getId(), product.getId()))
                .order(order)
                .product(product)
                .quantityOfGoodsInTheOrder(1)
                .build();
        goodInOrderService.add(
                testGoodInOrder
        );
        List<GoodInOrder> all = goodInOrderService.getAll();
        Assert.assertNotNull(all.contains(testGoodInOrder));
    }*/

    /*@Test
    public void updateOrder() {
        Order order = Order.builder()
                .id(5L)
                .address("AAAAAAA")
                .dateOfOrder(LocalDate.now())
                .deliveryDate(LocalDate.now())
                .goodInOrder(new ArrayList<>())
                .status(OrderStatus.REVIEWING)
                .build();

        Brand brand = Brand.builder()
                .country("AAAAAA")
                .name("AAAAAAA")
                .build();
        Product product = Product.builder()
                .id(5L)
                .brand(brand)
                .price(BigDecimal.valueOf(1.1))
                .productCharacteristic("AAAAAAAAAAAA")
                .dateOfIssue(LocalDate.now())
                .name("AAAAAAAAAAAA")
                .build();
        GoodInOrder testGoodInOrder = GoodInOrder.builder()
                .id(new GoodInOrderPk(order.getId(), product.getId()))
                .order(order)
                .product(product)
                .quantityOfGoodsInTheOrder(1)
                .build();
        goodInOrderService.update(testGoodInOrder);
    }*/

    @Test
    public void getByIdOrder() {
        goodInOrderService.getById(new GoodInOrderPk(2L, 2L));
    }

    @Test
    public void getAllOrder() {
        List<GoodInOrder> orders = goodInOrderService.getAll();
        Assert.assertNotNull(orders);
        System.out.println(orders.get(1));


    }

   /* @Test
    public void deleteOrder() {
        Order order = Order.builder()
                .id(5L)
                .address("testAddress")
                .dateOfOrder(LocalDate.now())
                .deliveryDate(LocalDate.now())
                .goodInOrder(new ArrayList<>())
                .status(OrderStatus.REVIEWING)
                .build();

        Brand brand = Brand.builder()
                .country("testCountry")
                .name("testName")
                .build();
        Product product = Product.builder()
                .id(5L)
                .brand(brand)
                .price((1.1)
                .productCharacteristic("productCharacTest")
                .dateOfIssue(LocalDate.now())
                .name("testPhoneModel")
                .build();
        GoodInOrder testGoodInOrder = GoodInOrder.builder()
                .id(new GoodInOrderPk(order.getId(), product.getId()))
                .order(order)
                .product(product)
                .quantityOfGoodsInTheOrder(1)
                .build();
        goodInOrderService.delete(
                testGoodInOrder
        );
    }*/
}

