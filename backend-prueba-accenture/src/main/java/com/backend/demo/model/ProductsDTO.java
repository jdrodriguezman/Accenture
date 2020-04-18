package com.backend.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO implements Serializable {

    ArrayList<ProductDTO> listProducts;
    Integer totalValue;

    @Override
    public String toString() {
        return "ProductsDTO{" +
                "listProducts=" + listProducts +
                ", totalValue=" + totalValue +
                '}';
    }
}
