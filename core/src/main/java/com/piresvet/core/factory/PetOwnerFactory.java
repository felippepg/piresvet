package com.piresvet.core.factory;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.core.domain.valueobjects.Cpf;
import com.piresvet.core.domain.valueobjects.Name;

public class PetOwnerFactory {
    public PetOwner create(String firstname, String lastname, String cpf) {
        return new PetOwner(new Name(firstname), new Name(lastname), new Cpf(cpf));
    }

}
