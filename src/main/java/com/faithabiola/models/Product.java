package com.faithabiola.models;

import com.faithabiola.enums.Category;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Product {
    private String  productId;
    private String productName;
    private Double price;
    private Integer quantity;
    private Category category;
}
