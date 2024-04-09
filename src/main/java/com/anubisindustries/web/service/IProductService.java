package com.anubisindustries.web.service;

import com.anubisindustries.web.model.Product;
import java.util.List;

/**
 *
 * @author altrax
 */
public interface IProductService {
    
    Integer save(Product product);
    
    void deactivate(String alias);
    
    List<Product> getProducts();
}
