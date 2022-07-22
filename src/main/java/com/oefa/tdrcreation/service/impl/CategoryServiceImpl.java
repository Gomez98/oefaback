package com.oefa.tdrcreation.service.impl;

import com.oefa.tdrcreation.model.Category;
import com.oefa.tdrcreation.repository.CategoryRepository;
import com.oefa.tdrcreation.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Category cat = categoryRepository.findById(category.getId()).orElse(null);
        if (cat == null){
            return cat;
        }
        return categoryRepository.save(category);
    }
}
