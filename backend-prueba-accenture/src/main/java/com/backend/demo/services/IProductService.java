package com.backend.demo.services;

import com.backend.demo.model.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface IProductService {
    ResponseEntity createProductImpl(ProductDTO product);

    ResponseEntity getProductByIdImpl(String id);

    ResponseEntity getAllProductsImpl();

    ResponseEntity updateProductImpl(String id, ProductDTO product);

    ResponseEntity deleteProductImpl(String id);
}
