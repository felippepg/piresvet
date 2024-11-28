package com.piresvet.gatewayContracts.Pet;

import com.piresvet.core.domain.Pet;

import java.util.UUID;

public interface UpdatePetGateway {
    Pet update(UUID id);
}
