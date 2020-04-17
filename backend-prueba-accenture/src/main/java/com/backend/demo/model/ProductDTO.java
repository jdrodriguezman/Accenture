package com.backend.demo.model;
import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable{
	String category;
     String description;
     String identification;
     String initdate;
     String productname;
     Integer value;
}
