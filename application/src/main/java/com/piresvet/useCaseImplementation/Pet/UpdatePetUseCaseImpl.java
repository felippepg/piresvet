package com.piresvet.useCaseImplementation.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.core.exception.PetNotFoundException;
import com.piresvet.gatewayContracts.Pet.FindPetsGateway;
import com.piresvet.gatewayContracts.Pet.UpdatePetGateway;
import com.piresvet.useCaseContracts.Pet.UpdatePetUseCase;

import java.util.UUID;

public class UpdatePetUseCaseImpl implements UpdatePetUseCase {
    private final UpdatePetGateway updatePetGateway;
    private final FindPetsGateway findPetsGateway;

    public UpdatePetUseCaseImpl(UpdatePetGateway updatePetGateway, FindPetsGateway findPetsGateway) {
        this.updatePetGateway = updatePetGateway;
        this.findPetsGateway = findPetsGateway;
    }

    @Override
    public Pet update(UUID id, Pet pet) {
        findPetsGateway.findPetById(id).orElseThrow(
                () -> new PetNotFoundException("Não foi possível localizar o Pet!"));
        return updatePetGateway.update(id, pet);
    }
}
