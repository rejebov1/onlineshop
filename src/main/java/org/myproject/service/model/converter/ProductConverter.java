package org.myproject.service.model.converter;

import org.myproject.repository.entity.Product;
import org.myproject.service.model.dto.ProductDTO;

public class ProductConverter {

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setProductCharacteristic(product.getProductCharacteristic());
        return productDTO;
    }


    public static Product fromDTO(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setProductCharacteristic(productDTO.getProductCharacteristic());
        product.setPrice(productDTO.getPrice());
        return product;
    }
}
