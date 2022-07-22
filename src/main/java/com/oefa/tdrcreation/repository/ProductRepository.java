package com.oefa.tdrcreation.repository;

import com.oefa.tdrcreation.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
