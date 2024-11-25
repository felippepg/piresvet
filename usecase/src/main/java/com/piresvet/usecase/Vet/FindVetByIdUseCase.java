package com.piresvet.usecase.Vet;

import com.piresvet.core.domain.Vet;

import java.util.UUID;

public interface FindVetByIdUseCase {
    Vet find(UUID id);
}
