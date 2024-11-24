package com.piresvet.usecase.PetOwner;

import com.piresvet.core.domain.Vet;

import java.util.UUID;

public interface UpdatePetOwnerUseCase {
    Vet update(UUID id);
}
