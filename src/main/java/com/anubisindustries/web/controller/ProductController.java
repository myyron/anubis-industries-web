package com.anubisindustries.web.controller;

import com.anubisindustries.web.dto.ProductDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @GetMapping("/list")
    public List<ProductDto> getProductList() {
        List<ProductDto> result = new ArrayList<>();
        ProductDto dto1 = new ProductDto();
        dto1.setName("R1");
        dto1.setVariation("orange");
        ProductDto dto2 = new ProductDto();
        dto2.setName("R1");
        dto2.setVariation("black");
        result.add(dto1);
        result.add(dto2);
        logger.info("getProductList - {}", result.size());
        return result;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) throws JsonProcessingException {
        logger.info(new ObjectMapper().writeValueAsString(productDto));
        return ResponseEntity.ok("User registered successfully!");
    }
}
