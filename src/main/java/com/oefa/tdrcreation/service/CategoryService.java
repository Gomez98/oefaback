package com.oefa.tdrcreation.service;

import com.oefa.tdrcreation.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listAllCategories();
    Category create(Category category);
    Category updateCategory(Category category);
}
