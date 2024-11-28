package com.piresvet.useCaseImplementation.PetOwner;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.gatewayContracts.PetOwner.FindPetOwnerGateway;
import com.piresvet.useCaseContracts.PetOwner.FindPetOwnerUseCase;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class FindPetOwnerUseCaseImpl implements FindPetOwnerUseCase {
    private final FindPetOwnerGateway findPetOwnerGateway;

    public FindPetOwnerUseCaseImpl(FindPetOwnerGateway findPetOwnerGateway) {
        this.findPetOwnerGateway = findPetOwnerGateway;
    }

    @Override
    public PetOwner findById(UUID id) {
        var optional = findPetOwnerGateway.findById(id);
        return optional.orElseThrow(() -> new NoSuchElementException("Não foi possível localizar tutor"));
    }

    @Override
    public List<PetOwner> findByFullname(String firstname, String lastname) {
        return findPetOwnerGateway.findByFullname(firstname, lastname);
    }

    @Override
    public PetOwner findByCpf(String cpf) {
        var optional = findPetOwnerGateway.findByCpf(cpf);
        return optional.orElseThrow(() -> new NoSuchElementException("Não foi possível localizar tutor"));
    }

    @Override
    public List<PetOwner> findAll() {
        return findPetOwnerGateway.findAll();
    }
}
