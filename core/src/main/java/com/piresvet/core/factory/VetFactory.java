package com.piresvet.core.factory;

import com.piresvet.core.domain.Vet;
import com.piresvet.core.domain.valueobjects.Crmv;
import com.piresvet.core.domain.valueobjects.Name;

import java.util.UUID;

public class VetFactory {
    public Vet create(String firstname, String lastname, String crmv) {
        return new Vet( new Name(firstname),new Name(lastname), new Crmv(crmv));
    }

    public Vet create(UUID id, String firstname, String lastname, String crmv, Boolean available) {
        return new Vet(id, new Name(firstname),new Name(lastname), new Crmv(crmv), available);
    }

}
