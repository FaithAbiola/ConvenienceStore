package com.faithabiola.models;

import com.faithabiola.enums.Gender;
import com.faithabiola.enums.Qualification;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Applicant extends Person {
    private Qualification qualification;
    public Applicant(String firstName, String lastName, Integer age, Gender sex, Qualification qualification) {
        super(firstName, lastName, age, sex);
        this.qualification = qualification;
    }
}
