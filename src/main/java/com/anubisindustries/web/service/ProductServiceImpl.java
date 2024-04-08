package com.anubisindustries.web.service;

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
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    @Transactional
    public Integer save(Product product) {
        return productRepository.save(product).getId();
    }
    
    @Override
    @Transactional
    public void delete(String alias) {
        productRepository.deleteByAlias(alias);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}
