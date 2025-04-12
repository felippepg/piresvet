package com.piresvet.useCaseImplementation.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.core.exception.PetNotFoundException;
import com.piresvet.core.exception.PetOwnerNotFoundException;
import com.piresvet.gatewayContracts.Pet.FindPetsGateway;
import com.piresvet.gatewayContracts.PetOwner.FindPetOwnerGateway;
import com.piresvet.useCaseContracts.Pet.FindPetsUseCase;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class FindPetsUseCaseImpl implements FindPetsUseCase {
    private final FindPetsGateway findPetsGateway;
    private final FindPetOwnerGateway findPetOwnerGateway;

    public FindPetsUseCaseImpl(FindPetsGateway findPetsGateway, FindPetOwnerGateway findPetOwnerGateway) {
        this.findPetsGateway = findPetsGateway;
        this.findPetOwnerGateway = findPetOwnerGateway;
    }

    @Override
    public List<Pet> findByPetOwnerCpf(String cpf) {
        findPetOwnerGateway.findByCpf(cpf).orElseThrow(() -> new PetOwnerNotFoundException("Tutor não encontrado"));
        return findPetsGateway.findByPetOwnerCpf(cpf);
    }

    @Override
    public List<Pet> findAllPets() {
        return findPetsGateway.findAllPets();
    }

    @Override
    public Pet findPetById(UUID id) {
        var optional = findPetsGateway.findPetById(id);
        return optional.orElseThrow(() -> new PetNotFoundException("Não foi possivel localizar o Pet"));
    }
}
