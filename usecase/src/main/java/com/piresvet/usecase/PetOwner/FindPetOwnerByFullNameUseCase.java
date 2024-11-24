package com.piresvet.usecase.PetOwner;

import com.piresvet.core.domain.PetOwner;

import java.util.List;

public interface FindPetOwnerByFullNameUseCase {
    List<PetOwner> find(String firstname, String lastname);
}
