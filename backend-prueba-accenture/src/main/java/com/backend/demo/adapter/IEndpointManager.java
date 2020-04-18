package com.backend.demo.adapter;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface IEndpointManager {
    
    ResponseEntity<?> endpointConsumerClient(final String pathEndpoint,
            final Class<?> typeResponse,
            final HttpMethod method,
            final Object body);
}
