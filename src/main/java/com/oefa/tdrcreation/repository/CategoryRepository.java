package com.oefa.tdrcreation.repository;

import com.oefa.tdrcreation.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
