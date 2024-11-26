package com.piresvet.usecaseimpl.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.gateway.Pet.FindPetsGateway;
import com.piresvet.gateway.Pet.UpdatePetGateway;
import com.piresvet.usecase.Pet.UpdatePetUseCase;

import java.util.UUID;

public class UpdatePetUseCaseImpl implements UpdatePetUseCase {
    private final UpdatePetGateway updatePetGateway;
    private final FindPetsGateway findPetsGateway;

    public UpdatePetUseCaseImpl(UpdatePetGateway updatePetGateway, FindPetsGateway findPetsGateway) {
        this.updatePetGateway = updatePetGateway;
        this.findPetsGateway = findPetsGateway;
    }

    @Override
    public Pet update(UUID id) {
        findPetsGateway.findPetById(id);
        return updatePetGateway.update(id);
    }
}
