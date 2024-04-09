package com.anubisindustries.web.controller;

import com.anubisindustries.web.dto.ProductDto;
import com.anubisindustries.web.model.Product;
import com.anubisindustries.web.service.IProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author altrax
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public List<ProductDto> getProductList() {
        Mapper mapper = new DozerBeanMapper();
        List<ProductDto> result = new ArrayList<>();
        for (Product product : productService.getProducts()) {
            result.add(mapper.map(product, ProductDto.class));
        }
        logger.info("product list - {}", result.size());
        return result;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) throws JsonProcessingException {
        logger.info("add product - {}", new ObjectMapper().writeValueAsString(productDto));
        Product product = new DozerBeanMapper().map(productDto, Product.class);
        productService.save(product);
        return ResponseEntity.ok("Product added successfully.");
    }
    
    @PostMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestBody String alias) throws JsonProcessingException {
        logger.info("delete product - {}", alias);
        productService.delete(alias);
        return ResponseEntity.ok("Product deleted successfully.");
    }
}
