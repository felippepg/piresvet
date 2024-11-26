package com.piresvet.usecaseimpl.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.gateway.Pet.FindPetsGateway;
import com.piresvet.usecase.Pet.FindPetsUseCase;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class FindPetsUseCaseImpl implements FindPetsUseCase {
    private final FindPetsGateway findPetsGateway;

    public FindPetsUseCaseImpl(FindPetsGateway findPetsGateway) {
        this.findPetsGateway = findPetsGateway;
    }

    @Override
    public List<Pet> findByPetOwnerCpf(String cpf) {
        return findByPetOwnerCpf(cpf);
    }

    @Override
    public List<Pet> findAllPets() {
        return findPetsGateway.findAllPets();
    }

    @Override
    public Pet findPetById(UUID id) {
        var optional = findPetsGateway.findPetById(id);
        return optional.orElseThrow(() -> new NoSuchElementException("Não foi possivel encontrar o Pet"));
    }
}
