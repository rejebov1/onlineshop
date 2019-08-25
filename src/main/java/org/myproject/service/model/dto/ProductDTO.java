package org.myproject.service.model.dto;

import org.myproject.repository.entity.Brand;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;


public class ProductDTO {

    private Long id;
    private String name;
    private String productCharacteristic;
    private BigDecimal price;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCharacteristic() {
        return productCharacteristic;
    }

    public void setProductCharacteristic(String productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
