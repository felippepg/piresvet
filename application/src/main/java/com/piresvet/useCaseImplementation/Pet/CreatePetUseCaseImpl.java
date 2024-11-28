package com.piresvet.useCaseImplementation.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.gatewayContracts.Pet.CreatePetGateway;
import com.piresvet.useCaseContracts.Pet.CreatePetUseCase;

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
