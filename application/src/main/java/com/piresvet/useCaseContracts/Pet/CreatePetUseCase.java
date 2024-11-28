package com.piresvet.useCaseContracts.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.core.domain.PetOwner;

public interface CreatePetUseCase {
    Pet create(Pet pet);
}
