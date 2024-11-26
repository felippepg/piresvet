package com.piresvet.usecaseimpl.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.gateway.Pet.CreatePetGateway;
import com.piresvet.usecase.Pet.CreatePetUseCase;

public class CreatePetUseCaseImpl implements CreatePetUseCase {
    private final CreatePetGateway createPetGateway;

    public CreatePetUseCaseImpl(CreatePetGateway createPetGateway) {
        this.createPetGateway = createPetGateway;
    }

    @Override
    public Pet create(Pet pet) {
        return createPetGateway.create(pet);
    }
}
