package com.backend.demo.controller;

import com.backend.demo.commons.constans.EndpointApi;
import com.backend.demo.model.ProductDTO;
import com.backend.demo.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = EndpointApi.API)
public class PruebaAccentureControllerImpl implements IPruebaAccentureController{

    @Autowired
    private IProductService productService;


    public PruebaAccentureControllerImpl(IProductService productService) {
        this.productService = productService;
    }

    @Override
    @PostMapping(EndpointApi.CREATE_PRODUCT)
    public ResponseEntity createProduct(@RequestBody ProductDTO product) {
        return productService.createProductImpl(product);
    }

    @Override
    @GetMapping(EndpointApi.GET_PRODUCT_BY_ID)
    public ResponseEntity getProductById(@PathVariable("id") String id) {
        return productService.getProductByIdImpl(id);
    }

    @Override
    @GetMapping(EndpointApi.GET_ALL_PRODUCTS)
    public ResponseEntity getAllProducts() {
        return productService.getAllProductsImpl();
    }

    @Override
    @PutMapping(EndpointApi.UPDATE_PRODUCT)
    public ResponseEntity updateProduct(@PathVariable("id") String id, @RequestBody ProductDTO product) {
        return productService.updateProductImpl(id, product);
    }

    @Override
    @DeleteMapping(EndpointApi.DELETE_PRODUCT)
    public ResponseEntity deleteProduct(@PathVariable("id") String id) {
        return productService.deleteProductImpl(id);
    }
}
