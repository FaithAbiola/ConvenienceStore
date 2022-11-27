package com.faithabiola.models;

import com.faithabiola.enums.Gender;
import com.faithabiola.enums.Role;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Staff extends Person{
    private Integer id;
    private Role role;

    public Staff(String firstName, String lastName, Integer age, Gender sex, Integer id, Role role) {
        super(firstName, lastName, age, sex);
        this.id = id;
        this.role = role;
    }

}
