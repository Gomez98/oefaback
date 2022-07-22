package com.oefa.tdrcreation.service.impl;

import com.oefa.tdrcreation.model.Product;
import com.oefa.tdrcreation.repository.ProductRepository;
import com.oefa.tdrcreation.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product pro = productRepository.findById(product.getId()).orElse(null);
        if(pro == null){
            return pro;
        }
        return productRepository.save(product);
    }
}
