package com.faithabiola.models;

import com.faithabiola.enums.Gender;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public abstract class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender sex;

}


