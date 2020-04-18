package com.backend.demo.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProductsDTOTest {

    @Test
    void setListProducts() {
        Assert.assertNotNull(new ProductsDTO().toString());
    }

    @Test
    void withParameter() {
        ProductsDTO productsDTO = new ProductsDTO(new ArrayList<>(),1220);
        Assert.assertNotNull(productsDTO);
    }

    @Test
    void withoutParameter() {
        ProductsDTO productsDTO = new ProductsDTO();
        Assert.assertNotNull(productsDTO);
    }

    @Test
    void setters() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategory("Postres");
        productDTO.setDescription("Delicioso postre para la tarde");
        productDTO.setIdentification("B01");
        productDTO.setInitdate("11-06-2019");
        productDTO.setProductname("Postre Brazo de Reina");
        productDTO.setValue(3700);
        ArrayList<ProductDTO> list = new ArrayList<>();
        list.add(productDTO);
        ProductsDTO productsDTO = new ProductsDTO(list,1220);
        Assert.assertNotNull(productsDTO);
    }

    @Test
    void getters(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.getCategory();
        productDTO.getDescription();
        productDTO.getIdentification();
        productDTO.getInitdate();
        productDTO.getProductname();
        productDTO.getValue();
        ArrayList<ProductDTO> list = new ArrayList<>();
        list.add(productDTO);
        ProductsDTO productsDTO = new ProductsDTO(list,1220);
        Assert.assertNotNull(productsDTO);
    }

    @Test
    void testToString() {
        Assert.assertNotNull(new ProductsDTO().toString());
    }

}