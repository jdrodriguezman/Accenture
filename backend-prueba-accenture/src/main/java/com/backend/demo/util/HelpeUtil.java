package com.backend.demo.util;

import com.backend.demo.model.ProductDTO;
import com.backend.demo.model.ProductsDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Iterator;

public class HelpeUtil {

    public static ProductsDTO totalValue(ResponseEntity responseEntity){
        ProductsDTO productsDTO = new ProductsDTO();
        ArrayList<ProductDTO> listProducts = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            JsonNode jsonNode = mapper.readTree(responseEntity.getBody().toString());
            Iterator<JsonNode> elements = jsonNode.elements();
            Integer totalValue = 0;
            while (elements.hasNext()) {
                JsonNode node = elements.next();
                ProductDTO productDTO = new ProductDTO();
                productDTO.setCategory(node.get("category").textValue());
                productDTO.setDescription(node.get("description").textValue());
                productDTO.setIdentification(node.get("identification").textValue());
                productDTO.setInitdate(node.get("initdate").textValue());
                productDTO.setProductname(String.valueOf(node.get("productname").textValue()));
                productDTO.setValue(Integer.parseInt(node.get("value").toString()));
                listProducts.add(productDTO);
                totalValue = totalValue + Integer.parseInt(node.get("value").toString());
            }
            productsDTO.setListProducts(listProducts);
            productsDTO.setTotalValue(totalValue);
            return productsDTO;
        }catch (Exception e){
            return productsDTO;
        }
    }
}
