package com.oefa.tdrcreation.controller;

import com.oefa.tdrcreation.model.Category;
import com.oefa.tdrcreation.model.Response;
import com.oefa.tdrcreation.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private  final CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Response> getAllCategories(){
        List<Category> list = categoryService.listAllCategories();
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("categories", list == null ? "" : list))
                        .message( list.isEmpty() ? "No categories registered" : "Categories retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCategory(@RequestBody @Valid Category category){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("category", categoryService.create(category)))
                        .message("Category created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @PostMapping ("/update")
    public ResponseEntity<Response> updateCategory(@RequestBody @Valid Category category){
        Category cat = categoryService.updateCategory(category);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("category", cat == null ? "": cat))
                        .message(cat == null ? "Category not found" : "Category updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
