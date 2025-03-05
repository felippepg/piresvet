package com.piresvet.useCaseImplementation.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.gatewayContracts.Pet.FindPetsGateway;
import com.piresvet.gatewayContracts.Pet.UpdatePetGateway;
import com.piresvet.useCaseContracts.Pet.UpdatePetUseCase;

import java.util.UUID;

public class UpdatePetUseCaseImpl implements UpdatePetUseCase {
    private final UpdatePetGateway updatePetGateway;

    public UpdatePetUseCaseImpl(UpdatePetGateway updatePetGateway) {
        this.updatePetGateway = updatePetGateway;
    }

    @Override
    public Pet update(UUID id, Pet pet) {
        return updatePetGateway.update(id, pet);
    }
}
