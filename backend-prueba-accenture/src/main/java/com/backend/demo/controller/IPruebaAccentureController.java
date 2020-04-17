package com.backend.demo.controller;

import com.backend.demo.model.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface IPruebaAccentureController {
    ResponseEntity createProduct(ProductDTO product);

    ResponseEntity getProductById(String id);

    ResponseEntity getAllProducts();

    ResponseEntity updateProduct(String id, ProductDTO product);

    ResponseEntity deleteProduct(String id);
}
