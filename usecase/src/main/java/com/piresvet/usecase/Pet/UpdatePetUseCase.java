package com.piresvet.usecase.Pet;

import com.piresvet.core.domain.Vet;

import java.util.UUID;

public interface UpdatePetUseCase {
    Vet update(UUID id);
}
