package com.piresvet.gatewayContracts.PetOwner;

import com.piresvet.core.domain.PetOwner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FindPetOwnerGateway {
    Optional<PetOwner> findById(UUID id);
    List<PetOwner> findByFullname(String firstname, String lastname);
    Optional<PetOwner> findByCpf(String cpf);
    List<PetOwner> findAll();
    List<PetOwner> findByName(String firstname);
}
