package com.anubisindustries.web.service;

import com.anubisindustries.web.dto.ProductDto;
import com.anubisindustries.web.model.Product;
import java.util.List;

/**
 *
 * @author altrax
 */
public interface IProductService {

    List<Product> getProducts();

    Integer save(ProductDto productDto);

    void edit(ProductDto productDto);

    void deactivate(String alias);
}
