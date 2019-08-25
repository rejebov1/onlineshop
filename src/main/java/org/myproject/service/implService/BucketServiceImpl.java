/*
package org.myproject.service.implService;

import org.myproject.repository.dao.hibernateDao.DaoList;
import org.myproject.repository.entity.Product;
import org.myproject.service.BucketService;
import org.myproject.service.model.Bucket;
import org.myproject.service.model.converter.OrderConverter;
import org.myproject.service.model.converter.ProductConverter;
import org.myproject.service.model.dto.OrderDTO;
import org.myproject.service.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;


@Service
public class BucketServiceImpl implements BucketService {

    @Autowired
    private Bucket bucket;

    @Autowired
    protected DaoList daoList;

    @Override
    @Transactional(readOnly = true)
    public void addToBucket(Long productId, Integer count) {
        Product product = daoList.getProductDao().getById(productId);
        bucket.addProduct(ProductConverter.toDTO(product), count);
    }

    @Override
    @Transactional(readOnly = true)
    public void removeFromBucket(Long productId) {
        Product product = daoList.getProductDao().getById(productId);
        bucket.removeProduct(ProductConverter.toDTO(product));
    }

    @Override
    @Transactional(readOnly = true)
    public void changeProductCount(Long productId, Integer newCount) {
        Product product = daoList.getProductDao().getById(productId);
        bucket.changeCount(ProductConverter.toDTO(product), newCount);
    }

    @Override
    @Transactional(readOnly = true)
    public int getProductCount(Long productId) {
        Product product = daoList.getProductDao().getById(productId);
        return bucket.getCount(ProductConverter.toDTO(product));
    }

    @Override
    public Set<Map.Entry<ProductDTO, Integer>> getAll() {
        return bucket.getAll();
    }

    @Override
    public Integer getTotalCount() {
        return bucket.getAll().size();
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<ProductDTO, Integer> product : bucket.getAll()) {
            totalPrice = totalPrice.add(product.getKey().getPrice().multiply(new BigDecimal(product.getValue())));
        }
        return totalPrice;
    }

    @Override
    public void cleanBucket() {
        bucket.clean();
    }

    @Override
    @Transactional(readOnly = true)
    public void loadOrderToBucket(Long orderId) {
        OrderDTO order = OrderConverter.toDTO(daoList.getOrderDao().getById(orderId), null);
        for (Map.Entry<ProductDTO, Integer> entry : order.getProducts().entrySet()) {
            bucket.addProduct(entry.getKey(), entry.getValue());
        }
    }
}*/
