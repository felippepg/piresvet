package com.piresvet.useCaseImplementation.PetOwner;

import com.piresvet.gatewayContracts.PetOwner.FindPetOwnerGateway;
import com.piresvet.useCaseContracts.PetOwner.DeletePetOwnerUseCase;

import java.util.UUID;

public class DeletePetOwnerUseCaseImpl implements DeletePetOwnerUseCase {
    private final FindPetOwnerGateway findPetOwnerGateway;
    private final DeletePetOwnerUseCase deletePetOwnerUseCase;

    public DeletePetOwnerUseCaseImpl(FindPetOwnerGateway findPetOwnerGateway, DeletePetOwnerUseCase deletePetOwnerUseCase) {
        this.findPetOwnerGateway = findPetOwnerGateway;
        this.deletePetOwnerUseCase = deletePetOwnerUseCase;
    }

    @Override
    public void delete(UUID id) {
        findPetOwnerGateway.findById(id);
        deletePetOwnerUseCase.delete(id);
    }
}
