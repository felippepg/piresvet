package com.piresvet.gatewayContracts.PetOwner;

import com.piresvet.core.domain.PetOwner;

import java.util.UUID;

public interface UpdatePetOwnerGateway {
    PetOwner update(UUID id, PetOwner petOwner);
}
