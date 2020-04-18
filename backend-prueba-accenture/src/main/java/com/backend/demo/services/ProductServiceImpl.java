package com.backend.demo.services;

import com.backend.demo.adapter.IEndpointManager;
import com.backend.demo.commons.constans.EndpointApi;
import com.backend.demo.model.ProductDTO;
import com.backend.demo.model.ProductsDTO;
import com.backend.demo.util.HelpeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import com.google.gson.Gson;

@Service
public class ProductServiceImpl implements IProductService {

    IEndpointManager endpointManager;

    @Autowired
    public ProductServiceImpl(IEndpointManager endpointManager) {
        this.endpointManager = endpointManager;
    }

    @Override
    public ResponseEntity createProductImpl(ProductDTO product) {
        try{
            String url = EndpointApi.URL_JSON;
            ResponseEntity responseEntity = endpointManager.endpointConsumerClient(url, String.class, HttpMethod.POST, new Gson().toJson(product));
            return responseEntity;
        }catch (HttpClientErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity getProductByIdImpl(String id) {
        try{
            String url = EndpointApi.URL + EndpointApi.SLASH +id + EndpointApi.JSON;
            ResponseEntity responseEntity = endpointManager.endpointConsumerClient(url, String.class, HttpMethod.GET,null);
            return responseEntity;
        }catch (HttpClientErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity getAllProductsImpl() {
        try{
            String url = EndpointApi.URL_JSON;
            ResponseEntity responseEntity = endpointManager.endpointConsumerClient(url, String.class, HttpMethod.GET,null);
            ProductsDTO productsDTO = HelpeUtil.totalValue(responseEntity);
            ResponseEntity<ProductsDTO> response = new ResponseEntity(productsDTO,responseEntity.getHeaders(),responseEntity.getStatusCode());
            return response;
        }catch (HttpClientErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity updateProductImpl(String id, ProductDTO product) {
        try{
            String url = EndpointApi.URL + EndpointApi.SLASH +id+ EndpointApi.JSON;
            ResponseEntity responseEntity = endpointManager.endpointConsumerClient(url, String.class, HttpMethod.PUT, new Gson().toJson(product));
            return responseEntity;
        }catch (HttpClientErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity deleteProductImpl(String id) {
        try{
            String url = EndpointApi.URL + EndpointApi.SLASH +id+ EndpointApi.JSON;
            ResponseEntity responseEntity = endpointManager.endpointConsumerClient(url, String.class, HttpMethod.DELETE, null);
            return responseEntity;
        }catch (HttpClientErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(e.getMessage());
        }
    }
}
