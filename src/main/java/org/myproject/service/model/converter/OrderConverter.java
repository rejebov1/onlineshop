/*
package org.myproject.service.model.converter;

import org.myproject.repository.entity.GoodInOrder;
import org.myproject.repository.entity.Order;
import org.myproject.repository.entity.enums.OrderStatus;
import org.myproject.service.model.dto.OrderDTO;
import org.myproject.service.model.dto.ProductDTO;
import org.myproject.service.model.dto.UserDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderConverter {

    public static OrderDTO toDTO(Order order, UserDTO userDTO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setStatus(order.getStatus());
        if (userDTO == null) {
            orderDTO.setUser(UserConverter.toDTO(order.getUser(), false));
        } else {
            orderDTO.setUser(userDTO);
        }

        if(order.getStatus().equals(OrderStatus.NEW)){
            orderDTO.setPossibleToEdit(true);
        }else{
            orderDTO.setPossibleToEdit(false);
        }

        BigDecimal totalPrice = new BigDecimal(0);
        for (GoodInOrder goodInOrder : order.getGoodInOrder()) {
            orderDTO.getProducts().put(ProductConverter.toDTO(goodInOrder.getProduct()), goodInOrder.getQuantityOfGoodsInTheOrder());
            totalPrice = totalPrice.add(goodInOrder.getProduct().getPrice().multiply(new BigDecimal(goodInOrder.getQuantityOfGoodsInTheOrder())));
        }
        orderDTO.setTotalPrice(totalPrice);

        return orderDTO;
    }

    public static Order fromDTO(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setStatus(orderDTO.getStatus());
        order.setUser(UserConverter.fromDTO(orderDTO.getUser(),false));

        for(Map.Entry<ProductDTO, Integer> product: orderDTO.getProducts().entrySet()){
            GoodInOrder goodInOrder = new GoodInOrder();
            goodInOrder.setProduct(ProductConverter.fromDTO(product.getKey()));
            goodInOrder.setQuantityOfGoodsInTheOrder(product.getValue());
            order.getGoodInOrder().add(goodInOrder);
        }
        return order;
    }

    public static List<OrderDTO> toDTO(List<Order> orders){
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(Order order: orders){
            orderDTOS.add(toDTO(order, null));
        }
        return orderDTOS;
    }
}
*/
