package com.anubisindustries.web.repository;

import com.anubisindustries.web.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author altrax
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByEnabled(Integer enabled);

    Product findByAlias(String alias);

//    @Modifying
//    @Query("update Product p set p.enabled = 0 where p.alias = ?1")
//    void deactivate(String alias);
}
