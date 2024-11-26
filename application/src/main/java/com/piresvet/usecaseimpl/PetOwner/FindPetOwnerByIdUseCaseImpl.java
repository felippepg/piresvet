package com.piresvet.usecaseimpl.PetOwner;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.gateway.PetOwner.FindPetOwnerByIdGateway;
import com.piresvet.usecase.PetOwner.FindPetOwnerByIdUseCase;

import java.util.NoSuchElementException;
import java.util.UUID;

public class FindPetOwnerByIdUseCaseImpl implements FindPetOwnerByIdUseCase {
    private final FindPetOwnerByIdGateway findPetOwnerByIdGateway;

    public FindPetOwnerByIdUseCaseImpl(FindPetOwnerByIdGateway findPetOwnerByIdGateway) {
        this.findPetOwnerByIdGateway = findPetOwnerByIdGateway;
    }

    @Override
    public PetOwner find(UUID id) {
        var optional = findPetOwnerByIdGateway.find(id);
        return optional.orElseThrow(()  -> new NoSuchElementException("Item não encontrado"));
    }
}
