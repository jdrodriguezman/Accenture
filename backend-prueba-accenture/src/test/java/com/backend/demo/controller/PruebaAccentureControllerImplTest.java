package com.backend.demo.controller;

import com.backend.demo.model.ProductDTO;
import com.backend.demo.services.IProductService;
import com.backend.demo.services.ProductServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;


class PruebaAccentureControllerImplTest {

    private PruebaAccentureControllerImpl controller;
    private IProductService service;

    @BeforeEach
    void setUp() {
        service = Mockito.mock(ProductServiceImpl.class);
        controller = new PruebaAccentureControllerImpl(service);
    }

    @Test
    void createProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategory("Postres");
        productDTO.setDescription("Delicioso postre para la tarde");
        productDTO.setIdentification("B01");
        productDTO.setInitdate("11-06-2019");
        productDTO.setProductname("Postre Brazo de Reina");
        productDTO.setValue(3700);
        Mockito.when(service.createProductImpl(productDTO)).thenReturn(new ResponseEntity("OK", HttpStatus.OK));

        ResponseEntity response = controller.createProduct(productDTO);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getProductById() {
        Mockito.when(service.getProductByIdImpl(any())).thenReturn(new ResponseEntity("OK", HttpStatus.OK));

        ResponseEntity response = controller.getProductById(any());
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getAllProducts() {
        Mockito.when(service.getAllProductsImpl()).thenReturn(new ResponseEntity("OK", HttpStatus.OK));

        ResponseEntity response = controller.getAllProducts();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void updateProduct() {
        ProductDTO productDTO = new ProductDTO(
                "Postres",
                "Delicioso postre para la tarde",
                "B01",
                "11-06-2019",
                "Postre Brazo de Reina",
                3700);

        Mockito.when(service.updateProductImpl("1", productDTO)).thenReturn(new ResponseEntity("OK", HttpStatus.OK));

        ResponseEntity response = controller.updateProduct("1", productDTO);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void deleteProduct() {
        Mockito.when(service.deleteProductImpl(any())).thenReturn(new ResponseEntity("OK", HttpStatus.OK));

        ResponseEntity response = controller.deleteProduct(any());
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}