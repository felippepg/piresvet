package com.piresvet.usecaseimpl.PetOwner;

import com.piresvet.gateway.PetOwner.DeletePetOwnerGateway;
import com.piresvet.usecase.PetOwner.DeletePetOwnerUseCase;

import java.util.UUID;

public class DeletePetOwnerUseCaseImpl implements DeletePetOwnerUseCase {
    private final DeletePetOwnerGateway deletePetOwnerGateway;
    @Override
    public void delete(UUID id) {
        deletePetOwnerGateway.delete(id);
    }
}
