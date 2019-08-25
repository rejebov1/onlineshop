package org.myproject.repository.entity;

import lombok.*;
import org.myproject.repository.entity.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "d_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Temporal(value = TemporalType.DATE)
    @Column(name = "date_of_order", nullable = false)
    private LocalDate dateOfOrder;

    //@Temporal(value = TemporalType.DATE)
    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @Column(name = "address", nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @Column(name = "status", columnDefinition = "enum", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<GoodInOrder> goodInOrder = new ArrayList<>();

}

