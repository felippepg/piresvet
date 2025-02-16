package com.piresvet.useCaseContracts.Vet;

import com.piresvet.core.domain.Vet;

import java.util.UUID;

public interface UpdateVetUseCase {
    Vet update(UUID id, Vet vet);
}
