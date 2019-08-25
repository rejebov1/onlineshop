package org.myproject.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "good_in_order")
public class GoodInOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //added 02.08

    /*@EmbeddedId
    private GoodInOrderPk id;*/

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",insertable = false, updatable = false, nullable = false)
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id",insertable = false, nullable = false,updatable = false)
    private Product product;

    @ManyToOne
    private Cart cart;

    @Column(name = "quantity_of_goods_in_the_order")
    private Integer quantityOfGoodsInTheOrder;

}