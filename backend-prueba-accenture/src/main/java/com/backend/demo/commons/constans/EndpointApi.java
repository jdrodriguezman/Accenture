package com.backend.demo.commons.constans;

public interface EndpointApi {
    String SLASH = "/";
    String JSON = ".json";
    String URL_JSON= "https://testbankapi.firebaseio.com/products.json";
    String URL= "https://testbankapi.firebaseio.com/products";
    String API = "products";
    String CREATE_PRODUCT = "/";
    String GET_PRODUCT_BY_ID = "/{id}";
    String GET_ALL_PRODUCTS = "/";
    String UPDATE_PRODUCT = "/{id}";
    String DELETE_PRODUCT = "/{id}";
}
