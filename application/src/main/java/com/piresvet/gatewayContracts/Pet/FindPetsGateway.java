package com.piresvet.gatewayContracts.Pet;

import com.piresvet.core.domain.Pet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FindPetsGateway {
    List<Pet> findByPetOwnerCpf(String cpf);
    List<Pet> findAllPets();
    Optional<Pet> findPetById(UUID id);

}
