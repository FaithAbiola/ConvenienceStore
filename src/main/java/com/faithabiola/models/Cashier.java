package com.faithabiola.models;

import com.faithabiola.enums.Gender;
import com.faithabiola.enums.Role;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Cashier extends Staff {
    public Cashier(String firstName, String lastName, Integer age, Gender sex, Integer id, Role role) {
        super(firstName, lastName, age, sex, id, role);
    }
}
