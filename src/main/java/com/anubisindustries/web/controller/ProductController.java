package com.anubisindustries.web.controller;

import com.anubisindustries.web.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author altrax
 */
@RestController
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    
//    @Autowired
//    private UserRepository userRepository;
    @GetMapping("/product/list")
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

//        User user = new User("kuku", passwordEncoder.encode(""));
//        userRepository.save(user);
        return result;
    }
}
