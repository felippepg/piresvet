package com.piresvet.usecase.PetOwner;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.core.domain.Vet;

import java.util.List;

public interface FindAllPetsOwnerUseCase {
    List<PetOwner> getPetsOwner();
}
