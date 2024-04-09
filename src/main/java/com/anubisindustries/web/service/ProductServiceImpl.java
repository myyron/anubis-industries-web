package com.anubisindustries.web.service;

import com.anubisindustries.web.model.ETransactionType;
import com.anubisindustries.web.model.Product;
import com.anubisindustries.web.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author altrax
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IActivityLogService activityLogService;

    @Override
    @Transactional
    public Integer save(Product product) {
        Integer productId = productRepository.save(product).getId();
        activityLogService.save(product, ETransactionType.ADD_PRODUCT);
        return productId;
    }

    @Override
    @Transactional
    public void deactivate(String alias) {
        productRepository.deactivate(alias);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAllByEnabled(1);
    }

}
