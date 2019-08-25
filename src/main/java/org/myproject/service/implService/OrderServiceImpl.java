package org.myproject.service.implService;

import org.myproject.repository.dao.hibernateDao.DaoList;
import org.myproject.repository.dao.hibernateDao.OrderDao;
import org.myproject.repository.entity.Order;
import org.myproject.repository.entity.enums.OrderStatus;
import org.myproject.service.OrderService;
import org.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserService userService;


    @Autowired
    private DaoList daoList;


    @Override
    @Transactional
    public Long addNewOrder(Order order) {
        return daoList.getOrderDao().add(order).getId();
    }


    @Override
    public void add(Order order) {
        orderDao.add(order);
    }


    @Override
    @Transactional
    public Order getById(Long id) {
       return daoList.getOrderDao().getById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public Order update(Order order) {
        return orderDao.update(order);
    }


//    @Override
//    public boolean delete(Long id) {
//        return orderDao.delete(id);
//    }

    @Override
    @Transactional
    public void deleteOrder(Long orderId) {
        Order order = daoList.getOrderDao().getById(orderId);
        if (order.getStatus() == OrderStatus.NEW) {
            daoList.getOrderDao().delete(new Order());
        }
    }
}
