package org.myproject.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Builder
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "country",nullable = false)
    private String country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand" ,fetch = FetchType.EAGER)
    private List<Product> product = new ArrayList<>();


}