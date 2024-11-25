package com.piresvet.gateway.PetOwner;

import com.piresvet.core.domain.Vet;

import java.util.UUID;

public interface UpdatePetOwnerGateway {
    Vet update(UUID id);
}
