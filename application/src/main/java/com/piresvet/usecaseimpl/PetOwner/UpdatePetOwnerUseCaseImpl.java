package com.piresvet.usecaseimpl.PetOwner;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.gateway.PetOwner.FindPetOwnerGateway;
import com.piresvet.gateway.PetOwner.UpdatePetOwnerGateway;
import com.piresvet.usecase.PetOwner.UpdatePetOwnerUseCase;

import java.util.UUID;

public class UpdatePetOwnerUseCaseImpl implements UpdatePetOwnerUseCase {
    private final FindPetOwnerGateway findPetOwnerGateway;
    private final UpdatePetOwnerGateway updatePetOwnerGateway;

    public UpdatePetOwnerUseCaseImpl(FindPetOwnerGateway findPetOwnerGateway, UpdatePetOwnerGateway updatePetOwnerGateway) {
        this.findPetOwnerGateway = findPetOwnerGateway;
        this.updatePetOwnerGateway = updatePetOwnerGateway;
    }

    @Override
    public PetOwner update(UUID id) {
        findPetOwnerGateway.findById(id);
        return updatePetOwnerGateway.update(id);
    }
}
