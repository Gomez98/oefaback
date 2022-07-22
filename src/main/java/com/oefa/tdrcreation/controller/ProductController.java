package com.oefa.tdrcreation.controller;

import com.oefa.tdrcreation.model.Product;
import com.oefa.tdrcreation.model.Response;
import com.oefa.tdrcreation.service.ProductService;
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
@RequestMapping("api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<Response> getAllProducts(){
        List<Product> list = productService.listAllProducts();
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("products", list))
                        .message( list.isEmpty() ? "No products registered" : "Products retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveProduct(@RequestBody @Valid Product product){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("product", productService.create(product)))
                        .message("Product created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @PostMapping ("/update")
    public ResponseEntity<Response> updateProduct(@RequestBody @Valid Product product){
        Product pro = productService.updateProduct(product);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("product", pro == null ? "": pro))
                        .message(pro == null ? "Product not found" : "Product updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
