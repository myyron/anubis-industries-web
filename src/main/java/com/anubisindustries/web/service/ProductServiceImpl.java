package com.anubisindustries.web.service;

import com.anubisindustries.web.dto.ProductDto;
import com.anubisindustries.web.model.ETransactionType;
import com.anubisindustries.web.model.Product;
import com.anubisindustries.web.repository.ProductRepository;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public Integer save(ProductDto productDto) {
        Product product = new DozerBeanMapper().map(productDto, Product.class);
        Integer productId = productRepository.save(product).getId();
        activityLogService.save(product, ETransactionType.ADD_PRODUCT);
        return productId;
    }

    @Override
    @Transactional
    public void edit(ProductDto productDto) {
        Product product = productRepository.findByAlias(productDto.getAlias());
        new DozerBeanMapper().map(productDto, product);
        activityLogService.save(product, ETransactionType.EDIT_PRODUCT);
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public void deactivate(String alias) {
        Product product = productRepository.findByAlias(alias);
        product.setEnabled(0);
        activityLogService.save(product, ETransactionType.DEL_PRODUCT);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAllByEnabled(1);
    }

}
