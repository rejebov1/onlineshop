package org.myproject.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    //@Temporal(value = TemporalType.DATE)
    @Column(name = "date_of_issue",nullable = false)
    private LocalDate dateOfIssue;

    @Column(name = "product_characteristic",nullable = false)
    private String productCharacteristic;

    @Column(name = "price",nullable = false)
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

}