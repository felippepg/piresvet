package com.piresvet.useCaseImplementation.PetOwner;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.core.exception.PetOwnerAlreadyExistsException;
import com.piresvet.core.exception.PetOwnerNotFoundException;
import com.piresvet.gatewayContracts.PetOwner.CreatePetOwnerGateway;
import com.piresvet.gatewayContracts.PetOwner.FindPetOwnerGateway;
import com.piresvet.useCaseContracts.PetOwner.CreatePetOwnerUseCase;

public class CreatePetOwnerUseCaseImpl implements CreatePetOwnerUseCase {
    private final CreatePetOwnerGateway createPetOwnerGateway;
    private final FindPetOwnerGateway findPetOwnerGateway;
    public CreatePetOwnerUseCaseImpl(CreatePetOwnerGateway createPetOwnerGateway, FindPetOwnerGateway findPetOwnerGateway) {
        this.createPetOwnerGateway = createPetOwnerGateway;
        this.findPetOwnerGateway = findPetOwnerGateway;
    }

    @Override
    public PetOwner create(PetOwner owner) {
        var existed = findPetOwnerGateway.findByCpf(owner.getCpf().getCpf());

        if(existed.isPresent()) {
            throw new PetOwnerAlreadyExistsException("Tutor já cadastrado!");
        }
        return createPetOwnerGateway.create(owner);
    }
}
