package com.piresvet.usecase.PetOwner;

import com.piresvet.core.domain.PetOwner;

import java.util.UUID;

public interface FindPetOwnerByIdUseCase {
    PetOwner find(UUID id);
}
