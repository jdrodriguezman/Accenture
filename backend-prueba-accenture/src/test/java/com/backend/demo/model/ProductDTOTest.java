package com.backend.demo.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class ProductDTOTest {

    @Test
    void withParameter() {
        ProductDTO productDTO = new ProductDTO(
                "Postres",
                "Delicioso postre para la tarde",
                "B01",
                "11-06-2019",
                "Postre Brazo de Reina",
                3700);
        Assert.assertNotNull(productDTO);
    }

    @Test
    void withoutParameter() {
        ProductDTO productDTO = new ProductDTO();
        Assert.assertNotNull(productDTO);
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
        Assert.assertNotNull(productDTO);
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
        Assert.assertNotNull(productDTO);
    }
}