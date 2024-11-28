package com.piresvet.useCaseContracts.PetOwner;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.core.domain.Vet;

public interface CreatePetOwnerUseCase {
    PetOwner create(PetOwner owner);
}
