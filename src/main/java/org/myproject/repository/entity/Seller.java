package org.myproject.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "seller", schema = "public", pkColumnName = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "rating")
    private float rating;
}