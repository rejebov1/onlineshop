package org.myproject.repository.dao.hibernateDao;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class DaoList {

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private GoodInOrderDao goodInOrderDao;

    @Autowired
    private SellerDao sellerDao;
}
