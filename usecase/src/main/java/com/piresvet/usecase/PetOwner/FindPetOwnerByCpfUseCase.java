package com.piresvet.usecase.PetOwner;

import com.piresvet.core.domain.Vet;

public interface FindPetOwnerByCpfUseCase {
    Vet find(String cpf);
}
