package com.piresvet.usecase.Pet;

import com.piresvet.core.domain.Pet;

import java.util.List;

public interface FindPetByPetOwnerCpf {
    List<Pet> findByPetOwnerCpf(String cpf);
}
