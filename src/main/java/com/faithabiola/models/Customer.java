package com.faithabiola.models;

import com.faithabiola.enums.Gender;
import lombok.*;

import java.util.HashMap;
import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class Customer extends Person{
    private String phoneNumber;
    private Integer productQuantityInCart = 0;
    private Double wallet = 0.0;
    private Double totalAmountInCart = 0.0;
    private Map<Product, Integer> cart = new HashMap<>();

    public Customer(String firstName, String lastName, Integer age, Gender sex) {
        super(firstName, lastName, age, sex);
    }

}
