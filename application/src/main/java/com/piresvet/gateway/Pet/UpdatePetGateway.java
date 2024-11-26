package com.piresvet.gateway.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.core.domain.Vet;

import java.util.UUID;

public interface UpdatePetGateway {
    Pet update(UUID id);
}
