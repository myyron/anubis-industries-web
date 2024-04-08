package com.anubisindustries.web.repository;

import com.anubisindustries.web.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author altrax
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    public void deleteByAlias(String alias);
}
