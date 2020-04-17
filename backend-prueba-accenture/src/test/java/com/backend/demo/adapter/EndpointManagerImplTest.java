package com.backend.demo.adapter;

import com.backend.demo.commons.constans.EndpointApi;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


class EndpointManagerImplTest {
    EndpointManagerImpl endpointManager;

    @BeforeEach
    void setUp() {
        endpointManager = new EndpointManagerImpl();
    }

    @Test
    void endpointConsumerClient() {
        ResponseEntity response = endpointManager.endpointConsumerClient(EndpointApi.URL_JSON, String.class, HttpMethod.GET, null);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}