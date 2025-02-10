package com.piresvet.useCaseImplementation.PetOwner;

import com.piresvet.gatewayContracts.PetOwner.DeletePetOwnerGateway;
import com.piresvet.gatewayContracts.PetOwner.FindPetOwnerGateway;
import com.piresvet.useCaseContracts.PetOwner.DeletePetOwnerUseCase;

import java.util.UUID;

public class DeletePetOwnerUseCaseImpl implements DeletePetOwnerUseCase {
    private final FindPetOwnerGateway findPetOwnerGateway;
    private final DeletePetOwnerGateway deletePetOwnerGateway;

    public DeletePetOwnerUseCaseImpl(FindPetOwnerGateway findPetOwnerGateway, DeletePetOwnerGateway deletePetOwnerGateway) {
        this.findPetOwnerGateway = findPetOwnerGateway;
        this.deletePetOwnerGateway = deletePetOwnerGateway;
    }

    @Override
    public void delete(UUID id) {
        findPetOwnerGateway.findById(id);
        deletePetOwnerGateway.delete(id);
    }
}
