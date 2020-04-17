package com.backend.demo.services;

import com.backend.demo.adapter.EndpointManagerImpl;
import com.backend.demo.adapter.IEndpointManager;
import com.backend.demo.model.ProductDTO;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import static org.mockito.ArgumentMatchers.any;

class ProductServiceImplTest {

    private IProductService service;
    @Mock
    private IEndpointManager endpointManager;

    @BeforeEach
    void setUp() {
        endpointManager = new EndpointManagerImpl();
        service = new ProductServiceImpl(endpointManager);
    }

    @Test
    void createProductImpl() {
        try{
            ProductDTO productDTO = new ProductDTO();
            productDTO.setCategory("Postres");
            productDTO.setDescription("Delicioso postre para la tarde");
            productDTO.setIdentification("B01");
            productDTO.setInitdate("11-06-2019");
            productDTO.setProductname("Postre Brazo de Reina");
            productDTO.setValue(3700);

            ResponseEntity response = service.createProductImpl(productDTO);
            Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        }catch (HttpClientErrorException e) {
            Assert.assertEquals(any(),e.getMessage());
        }
        catch (Exception e) {
            Assert.assertEquals(any(),e.getMessage());
        }
    }

    @Test
    void getProductByIdImpl() {
        try{
            ResponseEntity response = service.getProductByIdImpl(any());
            Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        }catch (HttpClientErrorException e) {
            Assert.assertEquals(any(),e.getMessage());
        }
        catch (Exception e) {
            Assert.assertEquals(any(),e.getMessage());
        }
    }

    @Test
    void getAllProductsImpl() {
        try{
            ResponseEntity response = service.getAllProductsImpl();
            Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        }catch (HttpClientErrorException e) {
            Assert.assertEquals(any(),e.getMessage());
        }
        catch (Exception e) {
            Assert.assertEquals(any(),e.getMessage());
        }
    }

    @Test
    void updateProductImpl() {
        try {
            ProductDTO productDTO = new ProductDTO(
                    "Postres",
                    "Delicioso postre para la tarde",
                    "B01",
                    "11-06-2019",
                    "Postre Brazo de Reina",
                    3700);

            ResponseEntity response = service.updateProductImpl("1",productDTO);
            Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        }catch (HttpClientErrorException e) {
            Assert.assertEquals(any(),e.getMessage());
        }
        catch (Exception e) {
            Assert.assertEquals(any(),e.getMessage());
        }
    }

    @Test
    void deleteProductImpl() {
        try {
            ResponseEntity response = service.deleteProductImpl(any());
            Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        }catch (HttpClientErrorException e) {
            Assert.assertEquals(any(),e.getMessage());
        }
        catch (Exception e) {
            Assert.assertEquals(any(),e.getMessage());
        }
    }
}