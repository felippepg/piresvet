package com.piresvet.core.factory;

import com.piresvet.core.domain.Vet;
import com.piresvet.core.validation.Validator;

public class VetFactory {
    private Validator nameValidator;
    private Validator vetCrmvValidator;

    public VetFactory(Validator nameValidator, Validator vetCrmvValidator) {
        this.nameValidator = nameValidator;
        this.vetCrmvValidator = vetCrmvValidator;
    }

    public Vet create(String firstname, String lastname, String crmv) {
        nameValidator.validate(firstname);
        nameValidator.validate(lastname);
        vetCrmvValidator.validate(crmv);

        return new Vet(firstname, lastname, crmv);
    }
}
