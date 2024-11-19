package com.piresvet.core.factory;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.core.domain.Vet;
import com.piresvet.core.validation.Validator;

public class PetOwnerFactory {
    private Validator nameValidator;
    private Validator cpfValidator;

    public PetOwnerFactory(Validator nameValidator, Validator cpfValidator) {
        this.nameValidator = nameValidator;
        this.cpfValidator = cpfValidator;
    }

    public PetOwner create(String firstname, String lastname, String cpf) {
        nameValidator.validate(firstname);
        nameValidator.validate(lastname);
        cpfValidator.validate(cpf);

        return new PetOwner(firstname, lastname, cpf);
    }
}
