package com.piresvet.useCaseImplementation.Pet;

import com.piresvet.gatewayContracts.Pet.DeletePetGateway;
import com.piresvet.gatewayContracts.Pet.FindPetsGateway;
import com.piresvet.useCaseContracts.Pet.DeletePetUseCase;

import java.util.UUID;

public class DeletePetUseCaseImpl implements DeletePetUseCase {
    private final DeletePetGateway deletePetGateway;

    public DeletePetUseCaseImpl(DeletePetGateway deletePetGateway) {
        this.deletePetGateway = deletePetGateway;

    }

    @Override
    public void delete(UUID id) {
        deletePetGateway.delete(id);
    }
}
