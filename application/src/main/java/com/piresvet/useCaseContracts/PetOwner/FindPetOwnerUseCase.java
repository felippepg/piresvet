package com.piresvet.useCaseContracts.PetOwner;

import com.piresvet.core.domain.PetOwner;

import java.util.List;
import java.util.UUID;

public interface FindPetOwnerUseCase {
    PetOwner findById(UUID id);
    List<PetOwner> findByFullname(String firstname, String lastname);
    PetOwner findByCpf(String cpf);
    List<PetOwner> findAll();

}
