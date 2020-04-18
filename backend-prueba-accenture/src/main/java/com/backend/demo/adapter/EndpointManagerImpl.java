package com.backend.demo.adapter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EndpointManagerImpl implements IEndpointManager {

    public ResponseEntity endpointConsumerClient(final String pathEndpoint,
                                                 final Class<?> typeResponse,
                                                 final HttpMethod method,
                                                 final Object body) {

        RestTemplate clientConsumer = new RestTemplate();
        return clientConsumer.exchange(pathEndpoint, method, new HttpEntity<>(body), typeResponse);
    }


}
