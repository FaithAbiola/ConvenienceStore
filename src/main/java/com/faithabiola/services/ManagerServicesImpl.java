package com.faithabiola.services;

import com.faithabiola.enums.Qualification;
import com.faithabiola.interfaces.ManagerServices;
import com.faithabiola.models.Applicant;

public class ManagerServicesImpl implements ManagerServices {

    @Override
    public String hireApplicant(Applicant applicant) {
     if (applicant.getAge() >=18 && applicant.getQualification() == Qualification.OND){
         return "Congratulations! You are hired.";
     }
     return "Sorry, you didn't get the job";
    }
}
