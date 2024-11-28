package com.piresvet.useCaseContracts.Pet;

import com.piresvet.core.domain.Pet;

import java.util.List;
import java.util.UUID;

public interface FindPetsUseCase {
    List<Pet> findByPetOwnerCpf(String cpf);
    List<Pet> findAllPets();
    Pet findPetById(UUID id);

}
