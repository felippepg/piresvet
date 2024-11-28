package com.piresvet.useCaseImplementation.PetOwner;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.gatewayContracts.PetOwner.CreatePetOwnerGateway;
import com.piresvet.useCaseContracts.PetOwner.CreatePetOwnerUseCase;

public class CreatePetOwnerUseCaseImpl implements CreatePetOwnerUseCase {
    private final CreatePetOwnerGateway createPetOwnerGateway;

    public CreatePetOwnerUseCaseImpl(CreatePetOwnerGateway createPetOwnerGateway) {
        this.createPetOwnerGateway = createPetOwnerGateway;
    }

    @Override
    public PetOwner create(PetOwner owner) {
        return createPetOwnerGateway.create(owner);
    }
}
