package com.piresvet.useCaseImplementation.PetOwner;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.core.exception.PetOwnerNotFoundException;
import com.piresvet.gatewayContracts.PetOwner.FindPetOwnerGateway;
import com.piresvet.gatewayContracts.PetOwner.UpdatePetOwnerGateway;
import com.piresvet.useCaseContracts.PetOwner.UpdatePetOwnerUseCase;

import java.util.UUID;

public class UpdatePetOwnerUseCaseImpl implements UpdatePetOwnerUseCase {
    private final FindPetOwnerGateway findPetOwnerGateway;
    private final UpdatePetOwnerGateway updatePetOwnerGateway;

    public UpdatePetOwnerUseCaseImpl(FindPetOwnerGateway findPetOwnerGateway, UpdatePetOwnerGateway updatePetOwnerGateway) {
        this.findPetOwnerGateway = findPetOwnerGateway;
        this.updatePetOwnerGateway = updatePetOwnerGateway;
    }

    @Override
    public PetOwner update(UUID id, PetOwner petOwner) {
        findPetOwnerGateway.findById(id).orElseThrow(
                () -> new PetOwnerNotFoundException("Tutor não encontrado!"));
        return updatePetOwnerGateway.update(id, petOwner);
    }
}
