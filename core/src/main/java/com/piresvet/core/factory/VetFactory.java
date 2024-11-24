package com.piresvet.core.factory;

import com.piresvet.core.domain.Vet;
import com.piresvet.core.domain.valueobjects.Crmv;
import com.piresvet.core.domain.valueobjects.Name;

public class VetFactory {
    public Vet create(String firstname, String lastname, String crmv) {
        return new Vet( new Name(firstname),new Name(lastname), new Crmv(crmv));
    }

}
