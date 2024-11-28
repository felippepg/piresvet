package com.piresvet.useCaseImplementation.Pet;

import com.piresvet.gatewayContracts.Pet.FindPetsGateway;
import com.piresvet.useCaseContracts.Pet.DeletePetUseCase;

import java.util.UUID;

public class DeletePetUseCaseImpl implements DeletePetUseCase {
    private final DeletePetUseCase deletePetUseCase;
    private final FindPetsGateway findPetsGateway;

    public DeletePetUseCaseImpl(DeletePetUseCase deletePetUseCase, FindPetsGateway findPetsGateway) {
        this.deletePetUseCase = deletePetUseCase;
        this.findPetsGateway = findPetsGateway;
    }

    @Override
    public void delete(UUID id) {
        findPetsGateway.findPetById(id);
        deletePetUseCase.delete(id);
    }
}
