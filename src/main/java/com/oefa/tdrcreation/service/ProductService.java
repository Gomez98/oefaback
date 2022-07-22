package com.oefa.tdrcreation.service;

import com.oefa.tdrcreation.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();
    Product create(Product product);
    Product updateProduct(Product product);
}
