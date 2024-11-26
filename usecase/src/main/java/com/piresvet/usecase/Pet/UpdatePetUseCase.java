package com.piresvet.usecase.Pet;

import com.piresvet.core.domain.Pet;

import java.util.UUID;

public interface UpdatePetUseCase {
    Pet update(UUID id);
}
