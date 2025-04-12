package com.piresvet.useCaseImplementation.Pet;

import com.piresvet.core.exception.PetNotFoundException;
import com.piresvet.gatewayContracts.Pet.DeletePetGateway;
import com.piresvet.gatewayContracts.Pet.FindPetsGateway;
import com.piresvet.useCaseContracts.Pet.DeletePetUseCase;

import java.util.UUID;

public class DeletePetUseCaseImpl implements DeletePetUseCase {
    private final DeletePetGateway deletePetGateway;
    private final FindPetsGateway findPetsGateway;

    public DeletePetUseCaseImpl(DeletePetGateway deletePetGateway, FindPetsGateway findPetsGateway) {
        this.deletePetGateway = deletePetGateway;
        this.findPetsGateway =findPetsGateway;
    }

    @Override
    public void delete(UUID id) {
        findPetsGateway.findPetById(id).orElseThrow(
                () -> new PetNotFoundException("Não foi possível localizar o Pet!"));
        deletePetGateway.delete(id);
    }
}
