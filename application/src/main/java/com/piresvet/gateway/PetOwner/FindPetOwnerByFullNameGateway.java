package com.piresvet.gateway.PetOwner;

import com.piresvet.core.domain.PetOwner;

import java.util.List;

public interface FindPetOwnerByFullNameGateway {
    List<PetOwner> find(String firstname, String lastname);
}
