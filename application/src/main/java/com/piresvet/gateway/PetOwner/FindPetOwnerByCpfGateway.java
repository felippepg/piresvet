package com.piresvet.gateway.PetOwner;

import com.piresvet.core.domain.Vet;

public interface FindPetOwnerByCpfGateway {
    Vet find(String cpf);
}
