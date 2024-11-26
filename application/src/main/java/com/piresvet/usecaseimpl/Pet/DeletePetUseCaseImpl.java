package com.piresvet.usecaseimpl.Pet;

import com.piresvet.core.domain.Vet;
import com.piresvet.gateway.Pet.FindPetsGateway;
import com.piresvet.gateway.Pet.UpdatePetGateway;
import com.piresvet.usecase.Pet.DeletePetUseCase;
import com.piresvet.usecase.Pet.UpdatePetUseCase;

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
