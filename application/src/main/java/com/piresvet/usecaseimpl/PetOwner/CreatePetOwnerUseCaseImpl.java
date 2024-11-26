package com.piresvet.usecaseimpl.PetOwner;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.gateway.PetOwner.CreatePetOwnerGateway;
import com.piresvet.usecase.PetOwner.CreatePetOwnerUseCase;

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
